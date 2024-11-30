
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Andre Arsyan Jordie        |
| Date         | 11/28/2024                 |
| Course       | Fall                       |
| Assignment # | Final Project              |
| Github | [Link](https://github.com/AndreArsyan/CS665-Final-Project)|

# MBTA Notification System
As an MBTA rider, I often miss trains or arrived too early at the station.
### Proposed Solution:
- I want notifications `x` minutes before the train arrives.
- I want to choose between **App**, **Text**, or **Email** notifications.
- I don't care whether it's an Express or Regular train as long as it is arrived at my station.

## Project Scope
- Only Green Line **B** branch.
- Branch always starts from Boston College and ends with Government Center station.
- Using a relative distance so that we can focus on the Notification feature, instead of train simulation.
- Express Train will skip some stations, while Regular Train will visit each station.
- Distance is measured in seconds. For example, distance from BU East to BU Central is 2 seconds.
- Ignore train speed. Every train is moving per second.
- Notification System is given delay to simulate real life situation and to prove Thread effectiveness.

## Technical Challenges
- Modelling MBTA Green Line B.
- Modelling moving trains.
- Modelling Regular and Express trains.
- Sending out notifications takes time, and main app shouldn't wait for it to be finished.
- Minimize coupling.

## Implementation Description
1. **Flexibility:** 
   - New notification types (e.g. Whatsapp Notifications) can be added easily.
   - New station can be added easily.
2. **Design Patterns:**
   
   Using several design pattern to model the real life.
   | Design Pattern       | Implement for                                         |
   |----------------------|-------------------------------------------------------|
   | **Observer Pattern** | Updates train locations in real time.                 |
   | **State Pattern**    | Differentiates between Regular and Express trains.    |
   | **Strategy Pattern** | Decides which notification channel to send            |
   | **Singleton Pattern**| Provides a list of available stations.                |
   | **Thread Pooling**   | Manages the resource allocation.                       |
   | **Iterator Pattern** | Simulates a moving train.                             |

3. **Modularity:**

   Each package only responsible for its domain (i.e. Station package will only contain classes for Station and its management only).

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
