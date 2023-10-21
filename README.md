# UWO-Campus-Maps-App

# Project Setup Guide

## Overview

This project aims to create an application that leverages the floor plans of University of Western Ontario buildings to assist users in navigating interior spaces. The application allows users to search for rooms, locate points of interest, and create their own points of interest. This README provides instructions on setting up and running the project.

For more detail about the project, please check out [Design Documentation](https://github.com/hanyunguo/UWO-Campus-Maps-App/blob/main/Design%20Document%20uwo.pdf) for the project.

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
