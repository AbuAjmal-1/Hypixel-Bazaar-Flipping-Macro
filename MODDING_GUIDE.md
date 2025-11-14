# How to Make a Minecraft 1.8.9 Forge Mod

This guide will walk you through the complete process of creating, building, and running a Minecraft 1.8.9 Forge mod.

## Prerequisites

Before you start, you need to have the following installed:

1. **Java Development Kit (JDK) 8**
   - Download from: https://adoptium.net/temurin/releases/?version=8
   - Minecraft 1.8.9 requires Java 8
   - Verify installation: `java -version` and `javac -version`

2. **Gradle** (Optional - the Gradle wrapper is included)
   - The project includes `gradlew` (Linux/Mac) and `gradlew.bat` (Windows)
   - These scripts will automatically download the correct Gradle version

## Project Structure

```
HypixelBazaarFlip/
├── build.gradle              # Main build configuration
├── settings.gradle            # Project settings
├── gradle.properties          # Gradle JVM settings
├── src/
│   └── main/
│       ├── java/             # Your mod's Java source code
│       │   └── com/hypixel/bazaarflip/
│       │       └── HypixelBazaarFlipMod.java
│       └── resources/        # Mod resources
│           └── mcmod.info    # Mod metadata
├── .gitignore                # Git ignore rules
└── MODDING_GUIDE.md          # This file
```

## Understanding the Core Files

### 1. build.gradle
This file contains all the build configuration:
- **ForgeGradle plugin**: Handles Forge-specific build tasks
- **Minecraft version**: Set to 1.8.9-11.15.1.2318-1.8.9
- **Mappings**: MCP mappings (stable_22) for deobfuscating Minecraft code
- **Dependencies**: External libraries your mod needs

### 2. HypixelBazaarFlipMod.java
The main mod class with key annotations:
- **@Mod**: Declares this class as a Forge mod
  - `modid`: Unique identifier (lowercase, no spaces)
  - `name`: Display name
  - `version`: Mod version
- **@Mod.EventHandler**: Methods called during mod loading phases
  - `preInit`: Early initialization (config, networking)
  - `init`: Main initialization (register events, commands)
  - `postInit`: Final initialization (integration with other mods)

### 3. mcmod.info
Metadata file that describes your mod:
- Displayed in the Minecraft mods list
- Contains mod name, description, version, and authors

## Building Your Mod

### Step 1: Setup the Workspace

First time setup to download Forge and set up the development environment:

```bash
# On Linux/Mac:
./gradlew setupDecompWorkspace

# On Windows:
gradlew.bat setupDecompWorkspace
```

This will:
- Download Minecraft 1.8.9 and Forge
- Deobfuscate the Minecraft code
- Set up your development workspace
- This may take 10-30 minutes on first run

### Step 2: Build the Mod

To compile your mod into a JAR file:

```bash
# On Linux/Mac:
./gradlew build

# On Windows:
gradlew.bat build
```

The compiled mod will be in: `build/libs/HypixelBazaarFlip-1.0.0.jar`

### Step 3: Test in Development Environment

To run Minecraft with your mod in a development environment:

```bash
# On Linux/Mac:
./gradlew runClient

# On Windows:
gradlew.bat runClient
```

This will:
- Launch Minecraft 1.8.9 with Forge
- Load your mod automatically
- Create a `run/` directory for game files

## Development Workflow

### IDE Setup

#### IntelliJ IDEA (Recommended)
```bash
./gradlew idea
```
Then open the project in IntelliJ IDEA.

#### Eclipse
```bash
./gradlew eclipse
```
Then import the project into Eclipse.

### Common Gradle Tasks

- `./gradlew clean` - Remove all build files
- `./gradlew build` - Build the mod JAR
- `./gradlew runClient` - Run Minecraft client with your mod
- `./gradlew runServer` - Run Minecraft server with your mod
- `./gradlew setupDecompWorkspace` - Setup workspace (first time only)

## Adding Features to Your Mod

### 1. Register Event Handlers

Events let your mod respond to game actions:

```java
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventHandler
public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(new MyEventHandler());
}

public class MyEventHandler {
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        // Called every client tick (20 times per second)
    }
}
```

### 2. Create Custom Commands

Commands let players interact with your mod:

```java
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class MyCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "bazaarflip";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/bazaarflip";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        // Command logic here
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}

// Register in init():
ClientCommandHandler.instance.registerCommand(new MyCommand());
```

### 3. Add Key Bindings

Let players configure keyboard shortcuts:

```java
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public static KeyBinding openGuiKey;

@Mod.EventHandler
public void init(FMLInitializationEvent event) {
    openGuiKey = new KeyBinding("Open Bazaar Flip GUI", Keyboard.KEY_B, "Bazaar Flip");
    ClientRegistry.registerKeyBinding(openGuiKey);
}
```

### 4. Create Custom GUIs

Build graphical interfaces:

```java
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;

public class MyGui extends GuiScreen {
    @Override
    public void initGui() {
        buttonList.add(new GuiButton(0, width / 2 - 50, height / 2, 100, 20, "Click Me"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            // Button clicked
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        drawCenteredString(fontRendererObj, "My Custom GUI", width / 2, 20, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
```

## Installing Your Mod

1. Build the mod: `./gradlew build`
2. Locate the JAR: `build/libs/HypixelBazaarFlip-1.0.0.jar`
3. Install Minecraft Forge 1.8.9: https://files.minecraftforge.net/net/minecraftforge/forge/index_1.8.9.html
4. Place the JAR in your Minecraft `mods` folder:
   - Windows: `%APPDATA%\.minecraft\mods`
   - Mac: `~/Library/Application Support/minecraft/mods`
   - Linux: `~/.minecraft/mods`
5. Launch Minecraft with the Forge 1.8.9 profile

## Debugging

### Enable Debug Logging

In your mod class:

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public static final Logger LOGGER = LogManager.getLogger(MODID);

@Mod.EventHandler
public void init(FMLInitializationEvent event) {
    LOGGER.info("Initializing mod...");
}
```

### Common Issues

1. **"Wrong Java version"**: Ensure you're using Java 8
2. **"Gradle build failed"**: Run `./gradlew clean` then try again
3. **"Mod not loading"**: Check that `modid` in `@Mod` matches `mcmod.info`
4. **"Class not found"**: Ensure `package` declaration matches folder structure

## Resources for Learning

- **Forge Documentation**: https://mcforge.readthedocs.io/
- **Forge Forums**: https://forums.minecraftforge.net/
- **MCP Bot**: https://mcp.thiakil.com/ (Search for Minecraft classes/methods)
- **Example Mods**: https://github.com/TheGreyGhost/MinecraftByExample

## Project-Specific Notes

This mod is designed for **Hypixel Bazaar flipping automation**. Key considerations:

- **Client-side only**: This is a client-side mod (no server component needed)
- **Hypixel rules**: Ensure any automation complies with Hypixel's rules
- **GUI automation**: Consider using event handlers and GUI overlays
- **Network requests**: Use async HTTP requests for bazaar data
- **Configuration**: Add a config file for user settings

## Next Steps

1. Study the existing code in `HypixelBazaarFlipMod.java`
2. Add event handlers for detecting bazaar interactions
3. Create a GUI overlay for displaying flip opportunities
4. Implement configuration system for user preferences
5. Add commands for controlling the mod
6. Test thoroughly on Hypixel's test server or in single-player

## Contributing

When adding new features:
1. Follow the existing code style
2. Test thoroughly before committing
3. Document new features in comments
4. Update this guide if adding new concepts

Happy modding!
