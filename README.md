#                                      Minecraft-Gui-Macro
A simple python script to automate mouse clicks and keyboard inputs through pyautogui;

Every slot for a minecraft chest/inventory is pre-coded as helper functions, making it alot easier.
The format for how the slots are layed out are as follows

# Slot Layouts

DoubleChest, 1-54 , starting from top left corner going each row left to right.

Inventory, 1-27, starting from top left corner going each row left to right.

Chest, 1-27, starting from top left corner going each row left to right.


# All helper functions:

click_slot(gui, slot, location="the slot layout"):

shift_click_slot(gui, slot, location="the slot layout", times=1):

wait(sec):

type_text(text):

press_key(key):

type_and_enter(text):

sign_done():

left_click(x, y, label=None):

right_click(x, y=None, label=None):

shift_left_click(x, y, times=1):

multi_click(x, y, times, cps, button='left'):

shift_double_click(x, y):

# How to write the macro:

    actions = [

        #you write the helper functions in the order you want here
        #add "lambda: " as a prefix to each function like this:

        lambda: click_slot(gui, 23, location="chest"),






    ]
    return actions

















