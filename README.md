### **Behavioral Design Patterns in Java**
Behavioral design patterns focus on communication between objects, ensuring flexible and efficient interaction.

### **Common Behavioral Design Patterns in Java**
1. **Chain of Responsibility** – Passes requests along a chain of handlers.
2. **Command** – Encapsulates a request as an object.
3. **Interpreter** – Defines a grammar and interprets sentences.
4. **Iterator** – Provides a way to traverse collections.
5. **Mediator** – Reduces direct dependencies between objects.
6. **Memento** – Saves and restores an object's state.
7. **Observer** – Defines a dependency between objects so that when one changes, others get notified.
8. **State** – Changes an object's behavior when its state changes.
9. **Strategy** – Defines a family of algorithms and makes them interchangeable.
10. **Template Method** – Defines the program skeleton in a base class and allows subclasses to override steps.
11. **Visitor** – Adds new operations to a class without modifying it.

---

## **Example: Observer Pattern**
The **Observer Pattern** allows one object (subject) to notify multiple observers when a change occurs.

### **Scenario:**
A news agency (`NewsAgency`) notifies subscribers (`NewsSubscriber`) when news is updated.

---

### **Step 1: Create the Observer Interface**
```java
interface Observer {
    void update(String news);
}
```

---

### **Step 2: Create the Subject Interface**
```java
import java.util.ArrayList;
import java.util.List;

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

---

### **Step 3: Implement the Concrete Subject (NewsAgency)**
```java
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers(); // Notify all subscribers when news is updated
    }
}
```

---

### **Step 4: Implement Concrete Observers (Subscribers)**
```java
class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}
```

---

### **Step 5: Test the Observer Pattern**
```java
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsSubscriber subscriber1 = new NewsSubscriber("Alice");
        NewsSubscriber subscriber2 = new NewsSubscriber("Bob");

        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);

        agency.setNews("Breaking: Observer Pattern Implemented in Java!");
        
        agency.removeObserver(subscriber1);
        
        agency.setNews("Update: More examples coming soon!");
    }
}
```

---

### **Output**
```
Alice received news update: Breaking: Observer Pattern Implemented in Java!
Bob received news update: Breaking: Observer Pattern Implemented in Java!
Bob received news update: Update: More examples coming soon!
```

---

### **Explanation**
1. `NewsAgency` (Subject) maintains a list of subscribers (`Observer`).
2. When news updates, `notifyObservers()` is called to send the update to all subscribers.
3. `NewsSubscriber` (Observers) receive and print the update.

---

### **Conclusion**
The **Observer Pattern** is useful for:
✔ Implementing event-driven systems.  
✔ Keeping dependencies minimal.  
✔ Ensuring automatic updates when state changes.

Would you like an example of another behavioral pattern? 😊
