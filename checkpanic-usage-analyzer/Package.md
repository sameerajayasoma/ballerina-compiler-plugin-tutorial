Detect and report warnings for each usage of the `checkpanic` construct.

# Package Overview
This package contains a Ballerina compiler plugin that detects and reports warnings for any usage of the `checkpanic` construct in Ballerina.

To engage this plugin with the compiler, you need to add an import declaration in one of your source files. 

```
import ballerina/os;
import ballerina/io;

import samjs/checkpanic_analyzer as _;

string host = os:getEnv("HOST");
int port = checkpanic int:fromString(os:getEnv("PORT"));

public function main() {
    checkpanic connect(host, port);
}

function connect(string host, int port) returns error? {
    if host == "" {
        return error("Invalid argument. Host cannot be empty");
    }

    io:println(string `Connected to ${host}:${port}`);
}

```

Here is the `bal build` output:
```
→ bal build

Compiling source
	sameera/myapp:0.1.0
WARNING [main.bal:(6:12,6:56)] checkpanic usage detected, consider check instead
WARNING [main.bal:(9:5,9:35)] checkpanic usage detected, consider check instead

Generating executable
	target/bin/myapp.jar

```

*Note that this package is written as part of a tutorial that explains how to develop a compiler plugin in Ballerina. This is not recommended for production usage.*