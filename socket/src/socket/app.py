from quart import Quart, render_template, websocket
import asyncio
from models.broker import Broker
from init_app import app

broker = Broker()

async def _receive() -> None:
    while True:
        message = await websocket.receive()
        await broker.publish(message)

@app.get("/")
async def index():
    return await render_template("index.html")

@app.websocket("/ws")
async def ws() -> None:
    try:
        task = asyncio.ensure_future(_receive())
        async for message in broker.subscribe():
            await websocket.send(message)
    except Exception as e:
        await websocket.accept()
        await websocket.close(1000)
        raise e
        
    except asyncio.CancelledError:
        # Handle disconnection here
        await websocket.accept()
        await websocket.close(1000)
        raise Exception(asyncio.CancelledError)
    finally:
        task.cancel()
        await task

def run() -> None:
    app.run()

if __name__ == "__main__":
    run()