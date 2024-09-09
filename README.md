<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->


<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="aura.png" alt="Logo" width="200" height="200">

<h3 align="center">AURA API</h3>

  <p align="center">
    Set of API for the mobile app AURA
  </p>
</div>

### Built With

* ![Kotlin]
* ![IntelliJ]
* ![gradle]

<!-- GETTING STARTED -->
## Getting Started

### Running

To run the server, execute the following command in the repository's root directory:
   ```sh
   ./gradlew run
   ```

## Documentation

The documentation of the API is available through SwaggerUI.

The page is available at the following endpoint: [http://127.0.0.1:8080/swagger](http://127.0.0.1:8080/swagger).

## Mock

Note that all the data are currently mocked with static data.

static data can be found into the `LocalApiService` file:

```kotlin
private val users = listOf(
    User("1234", "Pierre", "Brisette", "p@sswOrd", 2354.23), 
    User("5678", "Gustave", "Charbonneau", "T0pSecr3t", 521.36)
)
```

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[kotlin]: https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white
[intelliJ]: https://img.shields.io/badge/IntelliJ%20IDEA-20232A?style=for-the-badge&logo=intellijidea&logoColor=white
[gradle]: https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white