# protobuf-test
Study on [Google Protocol Buffers](https://developers.google.com/protocol-buffers/docs/overview) and how to use them in an SBT project.

# TL;DR
Protocol buffers are great for [schema evolution](http://doc.akka.io/docs/akka/2.4.1/scala/persistence-schema-evolution.html). 
Using an sbt plugin, .proto files can be compiled to Scala case classes and then be used for serializing to a binary format (byte array). 

# Overview
Protocol buffers are a flexible, efficient, automated mechanism for serializing structured data – think XML, but smaller, 
faster, and simpler. You define how you want your data to be structured once, then you can use special generated source code 
to easily write and read your structured data to and from a variety of data streams and using a variety of languages. 
You can even update your data structure without breaking deployed programs that are compiled against the "old" format.

You specify how you want the information you're serializing to be structured by defining protocol buffer message types 
in `.proto` files using an `IDL` or Interface Definition Language. Each protocol buffer `message` is a small logical 
record of information, containing a series of name-value pairs. eg:

```
option java_package = "docs.persistence.proto";
option optimize_for = SPEED;

message SeatReserved {
  required string letter   = 1;
  required uint32 row      = 2;
  optional string seatType = 3;
}
```

The message format is simple – each message type has one or more uniquely numbered fields, and each field has a name and a value type, 
where value types can be numbers (integer or floating-point), booleans, strings, raw bytes, or even other protocol buffer message types, 
allowing you to structure your data hierarchically. You can specify optional fields, required fields, and repeated fields. 

You can find more information about writing `.proto` files in the [Protocol Buffer Language Guide](https://developers.google.com/protocol-buffers/docs/proto).

# SBT
The project uses [ScalaPB: Protocol Buffer Compiler for Scala](https://trueaccord.github.io/ScalaPB/sbt-settings.html)
to compile `.proto` files, stored in `src/main/protobuf` to Scala case classes. 
 
Running the `compile` command in sbt will both generate Scala sources from your protos and compile them. 
If you just want to generate Scala sources for your protocol buffers without compiling them, run `protobuf:protobufScalaGenerate`.