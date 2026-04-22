# iron.view

These classes manage the user interface and display logic, allowing users to interact with the system.

* **LoginUI**: The initial interface where users input their credentials. Uses the `Authenticator` to validate access before navigating to the main interface.
* **MainUI**: The primary application shell that controls which dashboard is currently displayed. It acts as a container to set and display the appropriate user-specific dashboard.
* **AdminDashboard**: The interface presented to an `Admin` user, providing access to administrative menus and controls.
* **OrganizerDashboard**: The interface presented to an `Organizer`, providing access to race creation and management menus.
* **RacerDashboard**: The interface presented to a `Racer`, providing access to registration, history, and review menus.