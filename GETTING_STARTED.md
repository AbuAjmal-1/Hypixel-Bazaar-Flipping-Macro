# Getting Started with Your Minecraft 1.8.9 Forge Mod

This is a quick start guide to get you up and running with your new Minecraft 1.8.9 Forge mod in just a few minutes!

## 🚀 Quick Start (5 Minutes)

### Step 1: Install Java 8
You **must** have Java 8 (JDK 8) installed:
- Download: https://adoptium.net/temurin/releases/?version=8
- Verify: `java -version` (should show 1.8.x)

### Step 2: First Build
Run these commands in order:

```bash
# Linux/Mac:
./gradlew setupDecompWorkspace
./gradlew build

# Windows:
gradlew.bat setupDecompWorkspace
gradlew.bat build
```

⏱️ First run takes 10-30 minutes (downloads Minecraft and Forge)

### Step 3: Test Your Mod
```bash
# Linux/Mac:
./gradlew runClient

# Windows:
gradlew.bat runClient
```

This launches Minecraft 1.8.9 with your mod loaded!

## 📁 What's What?

- **`src/main/java/`** - Your Java code goes here
- **`HypixelBazaarFlipMod.java`** - Main mod file (starts here!)
- **`ExampleEventHandler.java`** - Example of listening to game events
- **`build.gradle`** - Build configuration (Forge version, dependencies)
- **`mcmod.info`** - Mod metadata (name, version, description)

## 🎯 Your First Change

Let's make the mod print a message when you press a key!

1. Open `HypixelBazaarFlipMod.java`
2. Find the `init()` method
3. Add this code inside it:

```java
// Register the example event handler
MinecraftForge.EVENT_BUS.register(new ExampleEventHandler());
```

4. Open `ExampleEventHandler.java`
5. You'll see it already prints every 5 seconds!

6. Rebuild and test:
```bash
./gradlew build
./gradlew runClient
```

## 📚 Next Steps

1. **Read the full guide**: Check out [MODDING_GUIDE.md](MODDING_GUIDE.md) for detailed information
2. **Add a command**: Make a `/bazaarflip` command
3. **Add a keybind**: Let players press a key to open your GUI
4. **Make a GUI**: Create a custom interface

## 🆘 Common Problems

### "Wrong Java version"
- You need Java 8, not Java 11 or 17
- Run `java -version` to check

### "Task 'setupDecompWorkspace' not found"
- Make sure you're in the project directory
- Check that `build.gradle` exists

### "Gradle build failed"
- Try: `./gradlew clean` then build again
- Make sure you have internet connection

### Mod doesn't show in game
- Check the Mods button in Minecraft main menu
- Look for "Hypixel Bazaar Flip"
- Check the console for errors

## 📖 Resources

- **Full Guide**: [MODDING_GUIDE.md](MODDING_GUIDE.md) - Everything you need to know
- **Forge Docs**: https://mcforge.readthedocs.io/
- **MCP Bot**: https://mcp.thiakil.com/ - Search Minecraft code
- **Example Mods**: https://github.com/TheGreyGhost/MinecraftByExample

## ⚠️ Important Warning

**Hypixel Rules**: Using automation or macros on Hypixel may violate their Terms of Service and can result in bans. This mod template is for educational purposes. Always check and follow Hypixel's current rules.

## 🎉 You're Ready!

You now have a working Minecraft 1.8.9 Forge mod! The next step is to add your own features. Check out `MODDING_GUIDE.md` for examples of:
- Event handlers
- Custom commands
- Key bindings
- Custom GUIs
- Configuration files

Happy modding! 🎮
