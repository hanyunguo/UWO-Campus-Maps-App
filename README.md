# 🗺️ UWO Campus Maps App

Welcome to the UWO Campus Maps App project! 🚀 This application is your ultimate guide to navigating the intricate interiors of University of Western Ontario buildings. Whether you're a student trying to find your next class, a visitor exploring the campus, or anyone in between, this app has got you covered! 🏫✨

## Project Setup Guide

This README provides a comprehensive guide to setting up and running the UWO Campus Maps App. If you're ready to embark on this journey with us, follow the steps below and get started! 🛠️🔍

## Overview

This innovative application utilizes the floor plans of UWO buildings, empowering users to seamlessly search for rooms, discover points of interest, and even mark their personalized points of interest. With our user-friendly interface and detailed maps, navigating the university spaces has never been this easy and enjoyable. 🎉

For in-depth insights into the project, dive into our [Design Documentation](https://github.com/hanyunguo/UWO-Campus-Maps-App/blob/main/Design%20Document%20uwo.pdf) and explore the project's vision, features, and more.

Let's get started! Feel free to reach out if you have any questions or need assistance along the way. Happy mapping! 🌍🔍

## Development Environment

### Integrated Development Environment (IDE) and Java Development Kit (JDK)

- **Apache NetBeans IDE 15:** Download and install NetBeans from the [official NetBeans website](https://netbeans.apache.org/download/index.html).
- **Java Development Kit (JDK 19):** Ensure you have JDK 19 installed on your system. Download JDK from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html). Follow the installation instructions provided on the website.

### Libraries and APIs

- **Gson (for JSON processing):**
  - Add Gson to your project using Apache Maven:
    ```xml
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.8.8</version> <!-- Check for the latest version on the official Gson GitHub repository -->
    </dependency>
    ```
  - For Gradle users, add this to your `build.gradle` file:
    ```gradle
    implementation 'com.google.code.gson:gson:2.8.8'
    ```

- **OpenWeatherMap API (for weather information):**
  - Sign up for a free student account on [OpenWeatherMap](https://home.openweathermap.org/users/sign_up) to obtain an API key.
  - Integrate the API key into your application for fetching current weather data. Refer to the [official OpenWeatherMap API documentation](https://openweathermap.org/api) for detailed usage instructions.

### Tools

- **Adobe Photoshop (for converting map PDFs into images):**
  - Use Photoshop or any image editing software to convert PDF maps into standardized images.
  - Open the PDF file in Photoshop and save each floor of the building as a separate image file (e.g., PNG or JPEG format).

- **Jira (for project management):**
  
- **Bitbucket (for project management):**

## Installation Steps

  **Clone the Repository:**
   ```
     $ git clone <repository_url>
     $ cd project-directory
   ```
## Running the Application

  - Compile and Run:
    - Compile and run the project using NetBeans IDE.
  - User Registration:
    - Users can register for an account by providing a username and password.
  - Application Usage:
    - Users can browse maps, search for POIs, mark favorites, and create custom POIs based on the implemented functionalities.
