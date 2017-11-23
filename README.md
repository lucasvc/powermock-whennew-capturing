# PowerMock `whenNew` and capturing same type objects issue

This is a [MCVE](https://stackoverflow.com/help/mcve) which shows that using [`PowerMock.whenNew`](https://static.javadoc.io/org.powermock/powermock-api-mockito/1.6.2/org/powermock/api/mockito/PowerMockito.html#whenNew-java.lang.Class-) method, when capturing same types objects (in the example, are both `String`'s), are not captured correctly, and mathes both in the first capturer.

There is the _domain_ object which has multiple constructors and a static factory method.
The unit tests tries to mock constructor and invoking the factory method. It is matched as the mock object is returned, but not correctly captured.

## Switch version
I've found the issue using 1.6.2 version, but switching the `build.gradle` version to 1.6.4 and executing
```
gradlew test
```
Unit test fails too.
