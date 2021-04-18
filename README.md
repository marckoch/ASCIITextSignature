# Jetbrains Academy - ASCII Text Signature

My solutions for the Jetbrains Academy Problem ASCII Text Signature

https://hyperskill.org/projects/71

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are four stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1/4

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/71/stages/390/implement)

First step of our ASCII generator.

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain
    
     _____________
    | Hyper Skill |
     •••••••••••••

## Stage 2/4

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/71/stages/391/implement)

Now user can enter his name in the console.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain

    Albert Einstein
    *******************
    * Albert Einstein *
    *******************

## Stage 3/4

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/71/stages/392/implement)

Enter name and status of a person.

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain
    
    Enter name and surname: Bill Gates
    Enter person's status: VIP
    ***************************************************
    *  ___  _ _    _         ____ ____ ___ ____ ____  *
    *  |__] | |    |         | __ |__|  |  |___ [__   *
    *  |__] | |___ |___      |__] |  |  |  |___ ___]  *
    *                       VIP                       *
    ***************************************************

## Stage 4/4

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/71/stages/393/implement)

We add a feature to sort the given numbers. Parameter _sortingType_ can be _natural_ or _byCount_.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain
    
    Enter name and surname: Bill Gates
    Enter person's status: VIP
    8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
    88  oooooooooo.   o8o  oooo  oooo              .oooooo.                  .                        88
    88  `888'   `Y8b  `"'  `888  `888             d8P'  `Y8b               .o8                        88
    88   888     888 oooo   888   888            888            .oooo.   .o888oo  .ooooo.   .oooo.o   88
    88   888oooo888' `888   888   888            888           `P  )88b    888   d88' `88b d88(  "8   88
    88   888    `88b  888   888   888            888     ooooo  .oP"888    888   888ooo888 `"Y88b.    88
    88   888    .88P  888   888   888            `88.    .88'  d8(  888    888 . 888    .o o.  )88b   88
    88  o888bood8P'  o888o o888o o888o            `Y8bood8P'   `Y888""8o   "888" `Y8bod8P' 8""888P'   88
    88                                                                                                88
    88                                                                                                88
    88                                                                                                88
    88                                          _  _ _ ___                                            88
    88                                          |  | | |__]                                           88
    88                                           \/  | |                                              88
    8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888