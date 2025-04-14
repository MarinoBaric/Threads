# 🧵 Threads Master Class 🧵

![Java Version](https://img.shields.io/badge/Java-17%2B-orange)
![License](https://img.shields.io/badge/License-MIT-blue)
![Last Updated](https://img.shields.io/badge/Last%20Updated-2025--04--14-brightgreen)
![Build Status](https://img.shields.io/badge/Build-Passing-success)

<div align="center">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="120" height="120"/>
  <br>
  <em>A comprehensive collection of assignments for mastering concurrency and threading in Java</em>
</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Learning Objectives](#-learning-objectives)
- [Repository Structure](#-repository-structure)
- [Assignment Progression](#-assignment-progression)
- [Getting Started](#-getting-started)
- [Threading Concepts Covered](#-threading-concepts-covered)
- [Example Assignment](#-example-assignment)
- [Best Practices](#-best-practices)
- [Contributing](#-contributing)
- [Resources](#-resources)
- [License](#-license)

---

## 🔍 Overview

Welcome to the **Threads Master Class** repository! This carefully curated collection of assignments is designed to take you from a threading novice to a concurrency expert in Java. Whether you're a computer science student, professional developer seeking to strengthen your skills, or an instructor looking for practical threading exercises, this repository has something valuable for you.

Threading is one of the most powerful yet challenging aspects of Java programming. Through hands-on practice, you'll learn how to create responsive applications, utilize multiple CPU cores efficiently, and build robust concurrent systems.

> "Learning concurrency is not just about writing multi-threaded code, but understanding how to orchestrate multiple execution flows safely and efficiently."

---

## 🎯 Learning Objectives

By completing the assignments in this repository, you will:

- **Master** the fundamentals of Java threading and the Thread lifecycle
- **Implement** various synchronization mechanisms to prevent race conditions
- **Design** thread-safe data structures and algorithms
- **Solve** classical concurrency problems (Producer-Consumer, Readers-Writers, etc.)
- **Utilize** modern Java concurrency APIs (ExecutorService, CompletableFuture, etc.)
- **Optimize** multi-threaded applications for performance and resource usage
- **Debug** threading issues including deadlocks, livelocks, and thread starvation
- **Apply** best practices in real-world concurrent programming scenarios

---

## 📂 Repository Structure
    <td><code>04-Advanced/ConcurrentCollections</code></td>
  </tr>
  <tr>
    <td>Deadlock Detection</td>
    <td>Identifying and preventing thread deadlocks</td>
    <td><code>05-ConcurrencyProblems/Deadlocks</code></td>
  </tr>
  <tr>
    <td>Parallel Algorithms</td>
    <td>Designing algorithms for multi-threaded execution</td>
    <td><code>06-PerformanceOptimization/</code></td>
  </tr>
</table>

---

## 📝 Example Assignment

Here's a preview of what you'll find in each assignment:

### Producer-Consumer Problem

**Objective**: Implement a thread-safe buffer with producer and consumer threads.

**Skills practiced**:
- Thread synchronization
- wait() and notify() mechanism
- Bounded buffer implementation
- Preventing deadlocks

**Sample Code**:

```java
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new BoundedBuffer(10); // Implement this class
        
        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    int value = buffer.get();
                    System.out.println("Consumed: " + value);
                    Thread.sleep((long) (Math.random() * 200));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        producer.start();
        consumer.start();
    }
}
```
**Challenge**: Extend the implementation to support multiple producers and consumers.

---

## 🛡️ Best Practices

Throughout this repository, we emphasize these threading best practices:

1. **Always name your threads** for easier debugging
2. **Prefer higher-level concurrency utilities** over raw threads when possible
3. **Minimize shared mutable state** between threads
4. **Use immutable objects** when sharing data between threads
5. **Keep synchronized blocks as small as possible**
6. **Prefer concurrent collections** over synchronized collections
7. **Document thread-safety assumptions** in your code
8. **Be aware of thread context switching overhead**
9. **Avoid complex synchronization schemes** that are hard to reason about
10. **Test thoroughly under high concurrency** to uncover race conditions

---

## 👥 Contributing

Contributions to improve the assignments or add new ones are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-assignment`
3. Commit your changes: `git commit -m 'Add new assignment for Fork/Join framework'`
4. Push to the branch: `git push origin feature/new-assignment`
5. Submit a pull request

Please ensure your contributions adhere to our coding standards and include appropriate tests.

---


## 📚 Resources

For additional learning, we recommend:

- [Java Concurrency in Practice](https://jcip.net/) by Brian Goetz
- [Oracle's Java Tutorials on Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Concurrent Programming in Java](https://www.coursera.org/learn/concurrent-programming-in-java) (Coursera)
- [Java Memory Model Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html)

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

<div align="center">
  <p>Created with ❤️ by <a href="https://github.com/MarinoBaric">Marino Barić</a></p>
  <p>Last updated: 2025-04-14 14:49:38</p>
  <p>
    <a href="https://github.com/MarinoBaric"><img src="https://img.shields.io/github/followers/MarinoBaric?label=Follow&style=social" alt="GitHub Follow"></a>
  </p>
</div>
