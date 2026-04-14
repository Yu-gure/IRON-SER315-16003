# iron.controller

These classes handle the business logic, mediate between the View and Model, and interact with the DataManager.

* **AdminController**: Handles administrative tasks such as managing users, licenses, and system settings. Saves data to the `DataManager`.
* **RaceController**: Manages race creation, updating details, setting limits, and entering results. Saves data to the `DataManager`.
* **RegistrationService**: Manages the sign-up process, license purchasing, and race reviewing. Saves data to the `DataManager`.
* **UpgradeService**: Handles category upgrades by evaluating `RaceResults` (e.g., checking for podium finishes) to determine eligibility.
* **LicenseService**: Manages license operations, including issuing, renewing, checking expiration, and validating eligibility for official races. Saves data to the `DataManager`.
* **NotificationService**: Handles generating and sending system messages to racers based on key events. Saves data to the `DataManager`.
* **ReviewService**: Manages race reviews, enforcing rules such as ensuring only participants can leave reviews. Saves data to the `DataManager`.
* **ResultService**: Manages the submission and retrieval of race results, standings, and podium information. Saves data to the `DataManager`.
* **Authenticator**: Validates user credentials during the login process.