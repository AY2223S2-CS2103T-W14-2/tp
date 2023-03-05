---
layout: page
title: Developer Guide
---
# **Table of Contents**
1. [Introduction](#1-introduction)
   * [Software Overview](#software-overview)
   * [Intended Audience](#intended-audience)
   * [Using the Guide](#using-the-guide)
   * [Content Overview](#content-overview)
   * [About Us](#about-us)
   * [Getting Help](#getting-help)
   * [Core Technologies](#core-technologies)
   * [Acknowledgements](#acknowledgements)
   * [Version Control](#version-control)
   * [Issue Tracker](#issue-tracker)
2. [Development Environment](#2-development-environment)
   * [Quick Start](#quick-start)
   * [Set Up Dependencies](#set-up-dependencies)
   * [Set Up Java](#set-up-java)
   * [Set Up PlantUML](#set-up-plantuml)
   * [Clone the EduMate Software Git Repo](#clone-the-edumate-software-git-repo)
3. [Tips](#3-tips)
   * [Sample Data](#sample-data)
4. [Design](#4-design)
   * [Architecture](#architecture)
   * [UI Component](#ui-component)
   * [Model Component](#model-component)
   * [Tag](#tag)
       * [Group Tag](#group-tag)
       * [Module Tag](#module-tag)
   * [Person](#person)
       * [Name](#name)
       * [Address](#address)
       * [Phone](#phone)
       * [Email](#email)
       * [Telegram Handle](#telegram-handle)
       * [Group Tag Set](#group-tag-set)
       * [Module Tag Set](#module-tag-set)
   * [Utils](#utils)
       * [Sample Data Util](#sample-data-util)
   * [Logic Component](#logic-component)
   * [Commands](#commands)
       * [Add Command](#add-command)
       * [Edit Command](#edit-command)
       * [Delete Command](#delete-command)
       * [Tag Command](#tag-command)
       * [User Command](#user-command)
       * [Find Command](#find-command)
       * [Sort Command](#sort-command)
       * [List Command](#list-command)
       * [Exit Command](#exit-command)
   * [Parsers](#parsers)
       * [Argument Multimap](#argument-multimap)
       * [Prefix](#prefix)
       * [Add Command Parser](#add-command-parser)
       * [Edit Command Parser](#edit-command-parser)
       * [Find Command Parser](#find-command-parser)
       * [Tag Command Parser](#tag-command-parser)
       * [Sort Command Parser](#sort-command-parser)
   * [Storage Component](#storage-component)
5. [Testing](#5-testing)
   * [Unit Tests](#unit-tests)
   * [Testing Models](#testing-models)
   * [Testing Commands](#testing-commands)
   * [Testing Parsers](#testing-parsers)
   * [Measuring Coverage of Integration Tests](#measuring-coverage-of-integration-tests)
   * [Create Code Coverage Report](#create-code-coverage-report)
   * [Read Code Coverage Report](#read-code-coverage-report)
   * [Continuous Integration](#continuous-integration)
6. [Documentation](#6-documentation)
   * [Using PlantUML](#using-plantuml)
     * [Creating Class Diagrams](#creating-class-diagrams)
     * [Creating Sequence Diagrams](#creating-sequence-diagrams)
7. [Appendix](#7-appendix)
   - [Glossary](#glossary)

# **1. Introduction**

## **Software Overview**
EduMate is a desktop app designed for NUS students to manage their academic and social lives. It is optimized for use through a Command Line Interface (CLI) while still providing the benefits of a Graphical User Interface (GUI). If you type quickly, eduMate can complete contact and module management tasks faster than traditional GUI apps.

## **Intended Audience**
This guide is intended primarily for developers who want to work on the **EduMate** Software code base at [https://github.com/AY2223S2-CS2103T-W14-2/tp](https://github.com/AY2223S2-CS2103T-W14-2/tp).

To get started, you'll want to set up your [Development Environment](#2-development-environment) and make sure you understand the branching strategy described in the [Version Control](#version-control) section and how to make a pull request. Thorough [testing](#5-testing) is expected for all pull requests, such that all testable methods are amply tested.

## **Using the Guide**
### **What Do the Emojis Mean**
:bulb: Tip - 

## **Content Overview**


## **About Us**
## **Getting Help**
## **Core Technologies**
## **Acknowledgements**
* This project is based on the [AddressBook Level 3 (AB3)](https://se-education.org/addressbook-level3/) project created by the [SE-EDU initiative](https://se-education.org/).
* Libraries used: [JavaFX](https://openjfx.io/), [JUnit5](https://github.com/junit-team/junit5).

## **Version Control**
### **The `master` Branch**
### **How to Make a Pull Request**

## **Issue Tracker**

# **2. Development Environment**

## **Quick Start**
## **Set Up Dependencies**
### **Set Up Java**
### **Set Up PlantUML**
### **Clone the EduMate Software Git Repo**

# **3. Tips**

## **Sample Data**

# **4. Design**

## **Architecture**
## **UI Component**

## **Model Component**
### **Tag**
#### **Group Tag**
#### **Module Tag**
### **Person**
#### **Name**
#### **Address**
#### **Phone**
#### **Email**
#### **Telegram Handle**
#### **Group Tag Set**
#### **Module Tag Set**
### **Utils**
#### **Sample Data Util**

## **Logic Component**
### **Commands**
#### **Add Command**
#### **Edit Command**
#### **Delete Command**
#### **Tag Command**
#### **User Command**
#### **Find Command**
#### **Sort Command**
#### **List Command**
#### **Exit Command**
### **Parsers**
#### **Argument Multimap**
#### **Prefix**
#### **Add Command Parser**
#### **Edit Command Parser**
#### **Find Command Parser**
#### **Tag Command Parser**
#### **Sort Command Parser**

## **Storage Component**

# **5. Testing**

## **Unit Tests**
### **Testing Models**
### **Testing Commands**
### **Testing Parsers**

## **Measuring Coverage of Integration Tests**
### **Create Code Coverage Report**
### **Read Code Coverage Report**

## **Continuous Integration**

# **6. Documentation**

## **Using PlantUML**
### **Creating Class Diagrams**
### **Creating Sequence Diagrams**

# **7. Appendix**

## **Glossary**

* **Command Line Interface (CLI)**: A text-based user interface (UI) used to run programs, manage computer files and interact with the computer
* **Graphical User Interface (GUI)**: A form of user interface that allows users to interact with electronic devices through graphical icons
* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **NUS**: National University of Singapore
* **Private contact detail**: A contact detail that is not meant to be shared with others
* **Pull Request (PR)**: An event that takes place in software development when a contributor/developer is ready to begin the process of merging new code changes with the main project repository

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Overview**

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.
</div>

### Architectur

<img src="images/ArchitectureDiagram.png" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** has two classes called [`Main`](https://github.com/AY2223S2-CS2103T-W14-2/tp/blob/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/AY2223S2-CS2103T-W14-2/tp/blob/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.


**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<img src="images/ComponentManagers.png" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

![Structure of the UI Component](images/UiClassDiagram.png)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

### Logic component

**API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<img src="images/LogicClassDiagram.png" width="550"/>

How the `Logic` component works:
1. When `Logic` is called upon to execute a command, it uses the `EduMateParser` class to parse the user command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `AddCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to add a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

The Sequence Diagram below illustrates the interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

The Sequence Diagram below illustrates the interactions within the `Logic` component for the `execute("add n/Bart...")` API call.

![Interactions Inside the Logic Component for the `add n/Bart...` Command](images/AddSequenceDiagram.png)

![Interactions Inside the Logic Component for the `add n/Bart...` Command](images/AddParserSequenceDiagram.png)

The Sequence Diagram below illustrates the interactions within the `Logic` component for the `execute("edit 1...")` API call.

![Interactions Inside the Logic Component for the `edit 1...` Command](images/EditSequenceDiagram.png)

![Interactions Inside the Logic Component for the `edit 1...` Command](images/EditParserSequenceDiagram.png)

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<img src="images/ParserClasses.png" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `EduMateParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `EduMateParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

### Model component
**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<img src="images/ModelClassDiagram.png" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `EduMate`, which `Person` references. This allows `EduMate` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects.<br>

<img src="images/BetterModelClassDiagram.png" width="450" />

</div>


### Storage component

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<img src="images/StorageClassDiagram.png" width="550" />

The `Storage` component,
* can save both address book data and user preference data in json format, and read them back into corresponding objects.
* inherits from both `EduMateStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

### Common classes

Classes used by multiple components are in the `seedu.edumate.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedEduMate`. It extends `EduMate` with an undo/redo history, stored internally as an `eduMateStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedEduMate#commit()` — Saves the current address book state in its history.
* `VersionedEduMate#undo()` — Restores the previous address book state from its history.
* `VersionedEduMate#redo()` — Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitEduMate()`, `Model#undoEduMate()` and `Model#redoEduMate()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedEduMate` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command calls `Model#commitEduMate()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `eduMateStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitEduMate()`, causing another modified address book state to be saved into the `eduMateStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitEduMate()`, so the address book state will not be saved into the `eduMateStateList`.

</div>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoEduMate()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial EduMate state, then there are no previous EduMate states to restore. The `undo` command uses `Model#canUndoEduMate()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoEduMate()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `eduMateStateList.size() - 1`, pointing to the latest address book state, then there are no undone EduMate states to restore. The `redo` command uses `Model#canRedoEduMate()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitEduMate()`, `Model#undoEduMate()` or `Model#redoEduMate()`. Thus, the `eduMateStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitEduMate()`. Since the `currentStatePointer` is not pointing at the end of the `eduMateStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

<img src="images/CommitActivityDiagram.png" width="250" />

#### Design considerations:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:

* has a need to manage a significant number of contacts
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps
* is an NUS student

**Value proposition**: help NUS students maintain both their social and academic life by lowering the barriers to meet up and make new friends within modules.


### User stories

Priorities: High (must have) - `***`, Medium (nice to have) - `**`, Low (unlikely to have) - `*`

| Priority | As a …​   | I want to …​                                           | So that I can…​                              |
|------|-----------|--------------------------------------------------------|----------------------------------------------|
| `***` | student   | view all my modules in one place                       | be more organised in my work                 |
| `***` | user      | use this app quickly with the command line             | quickly plan my modules                      |
| `***` | user      | view my personal information                           | share it to whoever needs it                 |
| `***` | user      | update my profile                                      | personalise my experience                    |
| `***` | user      | add module tags to new contacts                        | track what modules my friends are taking     |
| `***` | user      | tag and untag modules from existing contacts           | be flexible in recording my friends' modules |
| `***` | user      | filter my contacts based on module tag                 | find friends taking the same module as me    |
| `**` | user      | sort my contacts based on the number of shared modules | find out who are likely my close friends     |

### Use cases

(For all use cases below, the **System** is the `EduMate` and the **Actor** is the `user`, unless specified otherwise)

**Use case: UC01 - View the list of all contacts**

**MSS**

1. User requests to list contacts.
2. EduMate shows a list of all contacts.

    Use case ends.

**Extensions**

* 2a. The list is empty.

   Use case ends.

**Use case: UC02 - Add a contact**

**MSS**

1. User requests to add a person to the contact list with their details.
2. EduMate shows the list of contacts with the newly added person.

    Use case ends.

**Extensions**

* 1a. The given details are invalid.
    * 1a1. EduMate shows an error message.
    
    Use case resumes at step 1
* 1b. The person already exists in the contact list.
    * 1b1. EduMate shows an error message.
    
    Use case resumes at step 1

**Use case: UC03 - Edit a contact**

**MSS**

1. User requests to edit a person's details with new information.
2. EduMate edits the person's information.

    Use case ends.

**Extensions**

* 1a. The given index is invalid.
    * 1a1. EduMate shows an error message.
    
    Use case resumes at step 1.
* 1b. The given details are invalid.
    * 1b1. EduMate shows an error message.
  
    Use case resumes at step 1.

**Use case: UC04 - Delete a contact**

1. User requests to delete a person from the contact list.
2. EduMate deletes the person from the contact list.
    
    Use case ends.

**Extensions**

* 1a. The given index is invalid.
    * 1a1. EduMate shows an error message.

    Use case resumes at step 1.

**Use case: UC05 - Tag a module to a contact**

1. User requests to add a module tag to a contact.
2. EduMate tags the module to the contact.

    Use case ends.

**Extensions**

* 1a. The given index is invalid.
    * 1a1. EduMate shows an error message.
    
    Use case resumes at step 1.

* 1b. The given details is invalid.
    * 1b1. EduMate shows an error message.

    Use case resumes at step 1.

**Use case: UC06 - Untag a module from a contact**

1. User requests to remove a module tag from a contact.
2. EduMate untags the module from the contact.

    Use case ends.

**Extensions**

* 1a. The given index is invalid.
    * 1a1. EduMate shows an error message.

    Use case resumes at step 1.

* 1b. The given details is invalid.
    * 1b1. EduMate shows an error message.

    Use case resumes at step 1.

**Use case: UC07 - Tag a group to a contact**

1. User requests to add a group tag to a contact.
2. EduMate tags the group to the contact.

    Use case ends.

**Extensions**

* 1a. The given index is invalid.
    * 1a1. EduMate shows an error message.

    Use case resumes at step 1.

* 1b. The given details is invalid.
    * 1b1. EduMate shows an error message.

    Use case resumes at step 1.

**Use case: UC08 - Untag a group from a contact**

1. User requests to remove a group tag from a contact.
2. EduMate untags the group from the contact.

    Use case ends.

**Extensions**

* 1a. The given index is invalid.
    * 1a1. EduMate shows an error message.

    Use case resumes at step 1.

* 1b. The given details is invalid.
    * 1b1. EduMate shows an error message.

    Use case resumes at step 1.

**Use case: UC09 - Find contacts based on search criteria**

1. User requests to <u>view the list of contacts (UC01)</u>.
2. User requests to find contacts based on search criteria.
3. EduMate shows a list of contacts satisfying the search criteria.

    Use case ends.

**Extensions**

* 2a. The given details are invalid.
    * 2a1. EduMate shows an error message.

* 3a. The filtered list is empty.

    Use case ends

**Use case: UC10 - Sort contacts based on matching modules**

1. User requests to <u>view the list of contacts (UC01)</u>.
2. User requests to sort contacts.
3. EduMate shows a list of contacts sorted by their number of shared modules.

    Use case ends.

**Extensions**

* 3a. The sorted list is empty.

    Use case ends.

**Use case: UC11 - View user profile**

1. User requests to view their user profile.
2. EduMate shows the user information.

    Use case ends.

**Extensions**

* 2a. User information is empty.

    Use case ends.


### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4.  Should consistently execute commands within 1 second.

*{More to be added}*

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

    * 1a. Download the jar file and copy into an empty folder

    * 1b. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

2. Saving window preferences

    * 2a. Resize the window to an optimum size. Move the window to a different location. Close the window.

    * 2b. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

### Deleting a person

1. Deleting a person while all persons are being shown

    * 1a. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

    * 1b. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

    * 1c. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

    * 1d. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.


### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_
