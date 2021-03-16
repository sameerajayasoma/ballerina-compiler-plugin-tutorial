import samjs/checkpanic_analyzer as _;
import ballerina/os;
import ballerina/io;

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


