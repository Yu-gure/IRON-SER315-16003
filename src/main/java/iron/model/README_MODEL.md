# iron.model

These are the core domain classes representing the entities and data structures of the system.

* **User**: Represents a general system user. This acts as a parent class for all user types, consolidating shared fields like ID and name.
* **Organizer**: Inherits from User. Represents an organizer who manages races. Contains a list of managed races and uses a `RaceController`.
* **Racer**: Inherits from User. Represents a participant. Stores category, payment info, owns a `License`, tracks a history of `RaceResults`, maintains lists of `RaceReg` and `Notification`, and uses a `RegistrationService`.
* **Admin**: Inherits from User. Represents a system administrator. Uses an `AdminController` to oversee users, licenses, and settings.
* **Race**: Represents a race event. Stores details like title, date, type, distance, route, participant limit, registration deadline, allowed categories, and whether it is official. Can contain multiple `Stage` objects.
* **Stage**: Represents a segment or part of a multi-part `Race`.
* **License**: Represents a racer’s racing license. Stores ID, issue/expiry dates, category level, and active status.
* **RaceReg**: Represents a racer’s registration. Connects a `Racer` to a `Race` and tracks the registration date and status.
* **RaceResults**: Represents the outcome for a racer in a race. Stores placement and podium finish status.
* **RaceRev**: Represents a review submitted by a racer. Stores a rating and comment linking a `Racer` to a `Race`.
* **Notification**: Represents a system message sent to a `Racer` regarding events like registration or upgrades.
* **DataManager**: Handles data persistence logic (saving, loading, and updating records), acting as the central data access point for the application.