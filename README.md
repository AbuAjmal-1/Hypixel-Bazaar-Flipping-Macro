# Hypixel Bazaar Flipping Macro

A Minecraft 1.8.9 Forge mod for Hypixel Bazaar flipping automation.

## About This Project

This is a **Minecraft Forge mod** that runs directly inside Minecraft 1.8.9. Unlike external scripts that automate mouse clicks, this mod integrates with Minecraft's internal systems for better reliability and functionality.

## Quick Start

### Prerequisites
- Java 8 (JDK)
- Minecraft 1.8.9 with Forge installed

### Building the Mod

1. **First-time setup** (downloads Forge and sets up workspace):
   ```bash
   ./gradlew setupDecompWorkspace
   ```

2. **Build the mod**:
   ```bash
   ./gradlew build
   ```
   The mod JAR will be in `build/libs/`

3. **Test the mod**:
   ```bash
   ./gradlew runClient
   ```

### Installing the Mod

1. Build the mod using the instructions above
2. Install Minecraft Forge 1.8.9 from https://files.minecraftforge.net/
3. Copy `build/libs/HypixelBazaarFlip-1.0.0.jar` to your Minecraft `mods` folder
4. Launch Minecraft with the Forge 1.8.9 profile

## Documentation

For a complete guide on how to develop Minecraft 1.8.9 Forge mods, see **[MODDING_GUIDE.md](MODDING_GUIDE.md)**.

The guide covers:
- Setting up your development environment
- Understanding the project structure
- Building and testing your mod
- Adding features (events, commands, GUIs, keybindings)
- Debugging common issues
- Resources for learning more

## Project Structure

```
├── build.gradle                 # Gradle build configuration
├── src/main/java/              # Java source code
│   └── com/hypixel/bazaarflip/
│       ├── HypixelBazaarFlipMod.java      # Main mod class
│       └── ExampleEventHandler.java        # Example event handler
├── src/main/resources/         # Mod resources
│   └── mcmod.info              # Mod metadata
└── MODDING_GUIDE.md            # Complete modding guide
```

## Features

This is a starter template for creating a Hypixel Bazaar flipping mod. The basic mod structure is in place, and you can extend it with:

- Event handlers for detecting bazaar interactions
- GUI overlays for displaying flip opportunities  
- Configuration system for user preferences
- Commands for controlling the mod
- Keybindings for quick access

## Development

See [MODDING_GUIDE.md](MODDING_GUIDE.md) for detailed development instructions.

## Important Notes

⚠️ **Hypixel Rules**: Ensure any automation complies with Hypixel's Terms of Service and rules. Use of macros and automation may violate their policies.

⚠️ **Client-Side Only**: This mod is client-side only and does not require installation on servers.

## License

This project is open source. Please check Hypixel's rules before using any automation on their network.

















