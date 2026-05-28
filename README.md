# ScrollRebind — Forge 1.20.1 Port

A Forge 1.20.1 port of [ScrollRebind](https://github.com/Bishops-exe/ScrollRebind) by Bishops-exe.

Allows you to rebind your scroll wheel to any keyboard key.  
Once a scroll direction is bound, that direction no longer scrolls the hotbar.

## Usage

1. Open **Options → Controls**.
2. Find the **ScrollRebind** category.
3. Bind **Scroll Up** and/or **Scroll Down** to any key.

Leaving a direction unbound keeps vanilla hotbar scrolling for that direction.

## Building

Requires **JDK 17** and **Gradle 8+**.

```bash
./gradlew build
```

The built jar will be in `build/libs/`.

## Requirements

- Minecraft **1.20.1**
- Forge **47.3.0** or newer 47.x

## License

MIT — same as the original Fabric mod.
