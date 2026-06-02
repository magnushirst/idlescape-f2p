# AGENTS.md file
## Repository Layout
- `/antiban`: Code related to anti-ban measures, such as random mouse movements, camera movements, and other human-like behaviors.
- `/controller`: Classes which can hold state and encapsulate a mechanic to be used by multiple scripts
- `/events`: Handlers and listeners that run on their own thread and constantly check for certain conditions
- `/framework`: Core script classes and DTOs which run on a higher level to the scripts
- `/gamedata`: Enums to hold game data so we don't hardcode values in the scripts
- `/hid`: Mouse and keyboard algorithms 
- `/scripts`: The individual scripts which will be run by the user
- `/service`: Classes which call 3rd party services like HTTP or DB
- `/ui`: Launcher and paint overlay classes to run the bot and display information to the user
- `/utils`: Common code which doesn't hold state or acts as a facade to a library or to expand on dreambot apis
- `/webnodes`: Classes for creating the pathing in runescape

## Script Layout
At the root level of each Script, follow the standards:
- `Script Class`: Class extends `ScriptBranch` and should have the `@Script` annotation. Set `global = true` for scripts that run independently (like household tasks). The `isValid()` method should check the current running task to confirm it matches. The script should also be registered in `org.dreambot.Scripts`
- `Script Config`: Optional class to hold any state while the script runs. It typically contains static fields accessed through Getters and Setters
- `Launcher`: Class to run all the Java Swing components to add the task to the queue. Extends `PopupJFrame`
- `UI Config`: Optional class that implements `CachedConfig` to hold any state related to the UI. The script should not change these values at runtime. There is a `setup()` function which runs when the task is made active and current which can be used to clear any state. To get the UI Config, always use `CachedConfigRegistry.get(YourConfigClass.class)`
- `Leaves/`: Modules to contain all the SmartLeaves. It can be a flat module for simple scripts, or it can be broken down into submodules for more complex scripts. If it has submodules, it should mirror the same name of the branch which contains those leaves
- `Branches/`: Modules to contain all the branches
- `Data/`: Optional module to hold any data classes or enums related to the script

## Testing instructions
- Run `mvn test` to run all the tests
- Fix any test until the whole suite is green
- Don't write tests for Branches, Leaves, or SmartLeaves. Only write tests to protect shared, common code like controllers, Utils, and Services
- Test file names should follow the pattern `*Test.java` and be placed in the same package structure as `src/main/java`

## DreamBot API
- To look up any DreamBot class or method, run the lookup skill instead of reading the raw JSON:
  ```
  python scripts/dreambot_lookup.py Players
  python scripts/dreambot_lookup.py Players.getLocal
  python scripts/dreambot_lookup.py getLocal
  ```
- The script searches `docs/dreambot/javadoc_api.json` and returns a concise summary including the signature, return type, summary, and full description (with Returns/Parameters/Throws detail).
- If you have any questions about the API, ask the user and update your memory with the answer and save it in `docs/dreambot/memory.md`

## Review Checklist
- If you are running in a sandbox, use the docker image `mango1111/dreambot` which has Java, Maven and Dreambot installed
- You will need to copy over the repository code to the docker image to run the tests
- Make sure all tests pass with `mvn test`
- Make sure the code meets the Spotless standards by running `mvn spotless:apply`
- For any questions around the logic, only use https://oldschool.runescape.wiki/ as a source of information

## Code Standards
- Use minimal comments, use clear naming for variables and functions. If something is really unclear, move it to it's own function so you can name and encapsulate it
- Don't use any additional libraries without asking the user first
- Don't use any references to DreamBot API from outside this project. Only use existing code and `docs/dreambot/` as your source of information
- Don't use system printouts or DreamBot's Logger. Use the facade `StyledLogger` so we know where the log came from
- Use `SmartLeaf` instead of `Leaf` so we can add logging when the leaf is executing. Implement the `execute()` method instead of `onLoop()`
- In Leaves and Branches, put the `isValid` before the `onLoop()` (or `execute()` for SmartLeaves) function
- Default to use `LOOP_DELAY` when returning an `onLoop()` in leaves and branches
- Use DreamBot's sleep function to break up actions within a leaf
- Use the `@Script` annotation on script entry points. Set `global = true` for scripts that run independently across multiple tasks
