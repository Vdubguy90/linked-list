# JUnit 6.0.0

## To install JUnit 6.0.0, go to this page:
1. https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/6.0.0/
2. Download the `junit-platform-console-standalone-6.0.0.jar` file and place it in the `lib` directory of your project.


## Notes:
* JUnit 6.0.0 Jar is in the `lib` directory.
* Make sure the .vscode/settings.json file includes the following:
```
{
  "java.project.referencedLibraries": [
    "lib/**/*.jar"
  ]
}
```


## To compile
```
javac **/*.java -cp "lib/*:src" -d bin
```

## To discover tests 
```
java -jar lib/* discover --class-path bin --scan-class-path
```

## To run tests
```
java -jar lib/* execute --class-path bin --scan-class-path
```




