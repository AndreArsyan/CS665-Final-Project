
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Andre Arsyan Jordie        |
| Date         | 11/28/2024                 |
| Course       | Fall                       |
| Assignment # | Final Project              |
| Github | [Link](https://github.com/AndreArsyan/CS665-Final-Project)     |

# MBTA Notification System
As an MBTA rider, I often miss trains or arrive too early at the station.
### Proposed Solution:
- I want notifications `x` minutes before the train arrives.
- I want to choose between **App**, **Text**, or **Email** notifications.

## Technical Challenges
- Sending out notifications takes time, and main app shouldn't wait for it to be finished.

## Project Scope
- Assume train location is precise.
- Notification system is given delay to simulate real life situation and to prove Thread effectiveness.

## Implementation Description
1. **Flexibility:** 
   - New notification types (e.g., Whatsapp Notifications) can be added easily.
2. **Design Patterns:**
   - **Observer Pattern:** Updates train locations in real time.
   - **Strategy Pattern:** Decides what and when to send notification.
   - **Thread Pooling:** Manage notification mechanism.

For each assignment, please answer the following:
- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.
- Describe how you have avoided duplicated code and why it is important.

# Maven Commands
## Compile
```bash
mvn clean compile
```

## JUnit Tests
```bash
mvn clean test
```

## Spotbugs 
```bash
mvn spotbugs:gui 
```

## Checkstyle 
```bash
mvn checkstyle:checkstyle
```
The HTML page will be found at the following location:
`target/site/checkstyle.html`




