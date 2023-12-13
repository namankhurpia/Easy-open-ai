# Easy-open-ai
This repo contains the community library for OpenAI's API in java, the easiest way to use GPT 3/4 in your applications.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.namankhurpia/easyopenai/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.namankhurpia/easyopenai)

[![Your Custom Badge](https://img.shields.io/badge/Easyopenai-1.0.0-brightgreen)](https://central.sonatype.com/artifact/io.github.namankhurpia/easyopenai)

# Usage

## Overview

This Java library provides a convenient way to interact with OpenAI's API for both Moderation and Chat Completion. The library encapsulates the necessary details, making it easy to integrate OpenAI's powerful models into your Java applications.

## Table of Contents

- [Dependencies](#Dependencies) 

### Single Instance

- [Chat Completion API](#chat-completion-api)
- [Moderation API](#moderation-api)
- [Easy Vision API](#easy-vision-api)  or  [Vision API](#vision-api) (original provided by OpenAI)

### Asynchronous

- [Async Chat Completion API](#async-chat-completion-api)
- [Async Moderation API](#async-moderation-api)

### Multi-Asynchronous

- [Multithreaded Async Chat Completion API](#multithreaded-async-chat-completion-api)
- [Multithreaded Async Moderation API](#multithreaded-async-moderation-api)


## Chat Completion API

To use the Chat Completion API, follow these steps:

```java

Message message = Message.builder()
       .role("user")
       .content("what is the capital of Cambodia?")
       .build();

List<Message> messages = new ArrayList<>();
messages.add(message);

ChatCompletionRequest request = ChatCompletionRequest.builder()
       .model("gpt-3.5-turbo")
       .messages(messages)
       .build();

ChatCompletionResponse response = new EasyopenaiService(new DAOImpl()).chatCompletion(keys.get(0),request);

```

Click [here](#chat-completion-api) to jump to the code example.

## Moderation API

### Single Request, Single Response

To use the Moderation API, follow these steps:

```java

ModerationAPIRequest request = ModerationAPIRequest.builder()
        .model("text-moderation-latest")
        .input("hello from the other side kill me now")
        .build();

ModerationAPIResponse res = new EasyopenaiService(new DAOImpl()).getmoderation("OPENAI_KEY",request);
```

Click [here](#moderation-api) to jump to the code example.

## Easy Vision API

Vision API can be used like this, feel free to add N number of images in list of Images-

```java
VisionApiResponse responseobj = new EasyVisionService().VisionAPI("OPENAI_KEY", new EasyVisionRequest()
       .setModel("gpt-4-vision-preview")
       .setPrompt("What are the difference between these images?")
       .setImageUrls(new ArrayList<String>() {{
           add("https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
           add("https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
       }}));
```

```java
.setMaxtokens(1000) //Optional - for more tokens, defaults to 300
```

Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.


## Vision API

To use the Vision API, follow these steps:

1. Initialize the EasyopenaiService object with an instance of DAOImpl:


```java
EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
```

2. Create a VisionApiRequest object:


```java
VisionApiRequest request = new VisionApiRequest();
```
3. Create an ImageUrl object with the image URL and detail:


```java
ImageUrl url = new ImageUrl();
url.setUrl("https://images.pexels.com/photos/18907092/pexels-photo-18907092/free-photo-of-a-photo-of-the-golden-gate-bridge-in-the-sky.jpeg");
url.setDetail("low");
```
4. Create a list of Content objects to represent the messages:


```java
Content content1 = new Content();
content1.setText("What’s in this image?");
content1.setType("text");

Content content2 = new Content();
content2.setImageUrl(url);
content2.setType("image_url");

ArrayList<Content> listofContent = new ArrayList<>();
listofContent.add(content1);
listofContent.add(content2);
```
5. Create a MessageList object with the role ("user") and the list of content:


```java
MessageList messageList = new MessageList();
messageList.setRole("user");
messageList.setContent(listofContent);
```
6. Create a list of MessageList objects:


```java
ArrayList<MessageList> listofMessage = new ArrayList<>();
listofMessage.add(messageList);
```
7. Set various properties of the VisionApiRequest object:


```java
request.setModel("gpt-4-vision-preview");
request.setMaxTokens(300);
request.setMessages(listofMessage);
```
8. Make the API call and Print Response:


```java
VisionApiResponse res = obj.visionAPI(OPENAI_KEY, request);
System.out.println("Vision API Response is:" + res);
```

Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.

## Async Chat Completion API

To use the Chat Completion API asynchronously, follow these steps:

1. Initialize the `EasyopenaiAsyncService` object with an instance of `AsyncDAOImpl`:

    ```java
    EasyopenaiAsyncService obj = new EasyopenaiAsyncService(new AsyncDAOImpl());
    ```

2. Create a list of `ChatMessage` objects to represent the conversation:

    ```java
    ChatMessage message = new ChatMessage();
    message.setRole("user");
    message.setContent("what is the capital of Cambodia?");
    
    List<ChatMessage> messages = new ArrayList<>();
    messages.add(message);
    ```

3. Create a `ChatCompletionRequest` object:

    ```java
    ChatCompletionRequest request = new ChatCompletionRequest();
    request.setModel("gpt-3.5-turbo");
    request.setMessages(messages); // old conversations as well
    ```

4. Make the asynchronous API call:

    ```java
    ChatCompletionResponse res = obj.getAsyncChatCompletion(OPENAI_KEY, request);
    ```

Click [here](#async-chat-completion-api) to jump to the code example.

## Async Moderation API

To use the Moderation API asynchronously, follow these steps:

1. Create a `ModerationAPIRequest` object:

    ```java
    ModerationAPIRequest request = new ModerationAPIRequest();
    request.setInput("kill me now");
    request.setModel("text-moderation-latest");
    ```

2. Initialize the `EasyopenaiAsyncService` object with an instance of `AsyncDAOImpl`:

    ```java
    EasyopenaiAsyncService obj = new EasyopenaiAsyncService(new AsyncDAOImpl());
    ```

3. Make the asynchronous API call:

    ```java
    ModerationAPIResponse res = obj.getASyncModeration(OPENAI_KEY, request);
    ```

Click [here](#async-moderation-api) to jump to the code example.




## Multithreaded Async Chat Completion API

For multi-threading and concurrent calls with Chat Completion API, follow these steps:

1. Create a `ChatCompletionRequestList` object:

    ```java
    ChatCompletionRequestList list = new ChatCompletionRequestList(new ArrayList<ChatCompletionRequest>());
    ```

2. Add multiple `ChatCompletionRequest` objects to the list:

    ```java
    // Example request 1
    ChatCompletionRequest requestchat = new ChatCompletionRequest();
    requestchat.setModel("gpt-3.5-turbo");
    ChatMessage message = new ChatMessage();
    message.setRole("user");
    message.setContent("what is the capital of India?");
    List<ChatMessage> messages = new ArrayList<>();
    messages.add(message);
    requestchat.setMessages(messages);
    list.add(requestchat);

    // Add more requests as needed (requestchat2, requestchat3, requestchat4, etc.)
    ```

3. Make the multi-asynchronous API call:

    ```java
    EasyopenaiConcurrentService concurrentCalls = new EasyopenaiConcurrentService();
    ChatCompletionResponseList responseList = concurrentCalls.CallMultipleChatCompletionAPI(OPENAI_KEY, list);
    System.out.println(responseList);
    ```

Click [here](#multi-async-chat-completion-api) to jump to the code example.

## Multithreaded Async Moderation API

For multi-threading and concurrent calls with the Moderation API, follow these steps:

1. Create a `ModerationRequestList` object:

    ```java
    ModerationRequestList requestList = new ModerationRequestList(new ArrayList<ModerationAPIRequest>());
    ```

2. Add multiple `ModerationAPIRequest` objects to the list:

    ```java
    // Example request 1
    ModerationAPIRequest request = new ModerationAPIRequest();
    request.setInput("kill me now");
    request.setModel("text-moderation-latest");
    requestList.add(request);

    // Add more requests as needed (request2, request3, request4, etc.)
    ```

3. Make the multi-asynchronous API call:

    ```java
    EasyopenaiConcurrentService concurrentCalls = new EasyopenaiConcurrentService();
    ModerationResponseList responseList = concurrentCalls.CallMultipleModerationAPI(OPENAI_KEY, requestList);
    System.out.println(responseList);
    ```

Click [here](#multi-async-moderation-api) to jump to the code example.


# Dependencies

Ensure you have the required dependencies installed before using the OpenAI API wrapper.


## Maven

```xml
<dependency>
    <groupId>io.github.namankhurpia</groupId>
    <artifactId>easyopenai</artifactId>
    <version>1.0.4</version>
</dependency>
```

## Groovy - Gradle
```
implementation group: 'io.github.namankhurpia', name: 'easyopenai', version: '1.0.4'
```

## Gradle Java -
```
implementation 'io.github.namankhurpia:easyopenai:1.0.4'
```
## Gradle Kotlin-
```
implementation("io.github.namankhurpia:easyopenai:1.0.4")
```
## SBT -
```
libraryDependencies += "io.github.namankhurpia" % "easyopenai" % "1.0.4"
```
## Ivy-
```
<dependency org="io.github.namankhurpia" name="easyopenai" rev="1.0.4"/>
```
## Grape-
```
@Grapes(
@Grab(group='io.github.namankhurpia', module='easyopenai', version='1.0.4')
)
```
## Leiningen
```
[io.github.namankhurpia/easyopenai "1.0.4"]
```
## Buildr
```
'io.github.namankhurpia:easyopenai:jar:1.0.4'
```