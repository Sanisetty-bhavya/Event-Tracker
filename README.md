`INTRODUCTION:`

The main functionality of the code revolves around managing and displaying different types of events such as sleep, water intake, weight measurement, and exercise. The `Gathering` class acts as a data container, while the `Presentation` class provides the graphical user interface for interacting with the events.
Overall, the code allows users to track and record various events, view event data in a table, and save/load event data to/from a file.
Let's break down the code and describe the algorithms or protocols used in each section:
1. Class `Driver`:
   - The `main` method is the entry point of the application.
   - It launches the application by invoking `EventQueue.invokeLater` with a `Runnable` object that creates an instance of the `Presentation` class and sets its visibility to `true`.
2. Classes `Sleep`, `Water`, `Weight`, `Exercise`:
   - These classes extend the `Reporting` class (not provided in your code).
   - They define different types of events (Sleep, Water, Weight, Exercise) and provide methods to get the event details as an object array (`getRow`) and manipulate event-specific data.
3. Class `Gathering`:
   - This class manages a collection of events and provides methods to add new events (Sleep, Water, Weight, Exercise), end events, update event data, retrieve event data as a two-dimensional array (`getTableData`), delete events, and save/load event data using the `Persistency` class.
4. Class `Persistency`:
   - This class handles the persistence of event data by providing methods to save event data to a file (`saveFile`) and load event data from a file (`loadFile`).
5. Class `Presentation`:
   - This class represents the graphical user interface (GUI) of the application using Swing components.
   - It creates a JFrame window (`frmEventTracker`) and sets up the layout.
   - It includes various Swing components such as buttons, labels, combo boxes, and a table to display and interact with the event data.
   - The `updateTable` method updates the table with event data based on the selected event type.
   - The event handlers for buttons and toggles perform actions such as adding events, ending events, updating event data, clearing data, saving/loading data, etc.

Overall, the code demonstrates a simple event tracking application that allows the user to add different types of events, view and manipulate event data, and save/load event data to/from a file. The application follows a model-view-controller (MVC) design pattern, separating the data management logic (Gathering and Persistency classes) from the user interface (Presentation class).

`FLOWCHART:`

![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/6423b76f-eb49-453f-ac3a-c2c6c4420fbd)

`OUTPUTS:`

![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/221d33da-5dd5-4ad1-ada6-fd120f4afb42)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/3afa7476-031b-4742-b2c1-fded3a0519b8)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/07a36b2e-adbd-4999-99de-27c46f3ac7bd)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/d7df6c29-4e6b-4ff7-bdcc-69b4936b5380)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/2a7c5e9f-eecb-40aa-9a06-b75c439a07d7)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/f419d79b-968f-48e7-b26b-911bffbe7af2)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/6318dbc2-832d-4c4e-a9f2-dfe91a2f5cbf)
![image](https://github.com/Sanisetty-bhavya/Event-Tracker/assets/114378144/78ef216b-c28e-44e4-8fb3-2e4d9dd55a18)

`CONCLUSION:`
1. The code defines various classes such as `Driver`, `Sleep`, `Water`, `Weight`, `Exercise`, `Gathering`, `Persistency`, and `Presentation`. These classes are used to track different types of events and manage the data related to those events.
2. The `Gathering` class represents a collection of events and provides methods to add, update, and retrieve event data. It also has methods to save and load event data using the `Persistency` class.
3. The `Presentation` class creates a GUI application for the event tracker. It uses Swing components to display and interact with the event data. The GUI allows users to add different types of events, enter event details, and view the event data in a table.
4. The event types supported by the event tracker include Sleep, Exercise, Water, and Weight. Each event type has its own class (`Sleep`, `Exercise`, `Water`, `Weight`) that extends the `Reporting` class and provides specific functionality for that event type.
5. The event data is stored in an ArrayList within the `Gathering` class. The `Presentation` class interacts with the `Gathering` class to add, update, and retrieve event data.
Overall, the code implements an event tracking system with a graphical user interface, allowing users to track different types of events and view the event data in a table.
