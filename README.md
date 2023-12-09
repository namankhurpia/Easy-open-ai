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
- [Vision API](#vision-api)

### Asynchronous

- [Async Chat Completion API](#async-chat-completion-api)
- [Async Moderation API](#async-moderation-api)

### Multi-Asynchronous

- [Multithreaded Async Chat Completion API](#multithreaded-async-chat-completion-api)
- [Multithreaded Async Moderation API](#multithreaded-async-moderation-api)


## Chat Completion API

To use the Chat Completion API, follow these steps:

1. Initialize the `EasyopenaiService` object with an instance of `DAOImpl`:

```java
EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
```

2. Create a list of `ChatMessage` objects to represent the conversation:

```java
ChatMessage chatMessage = new ChatMessage();
chatMessage.setRole("user");
chatMessage.setContent("what is the capital of Cambodia?");
    
List<ChatMessage> messages = new ArrayList<>();
messages.add(chatMessage);
```

3. Create a `ChatCompletionRequest` object:

```java
ChatCompletionRequest request = new ChatCompletionRequest();
request.setModel("gpt-3.5-turbo");
request.setMessages(messages); // attach all old conversations here
```

4. Make the API call:

```java
ChatCompletionResponse res = obj.chatCompletion(OPENAI_KEY, request);
```

5. Print the response:

```java
System.out.println(res);
```

Click [here](#chat-completion-api) to jump to the code example.

## Moderation API

### Single Request, Single Response

To use the Moderation API, follow these steps:

1. Create a `ModerationAPIRequest` object:

```java
ModerationAPIRequest request = new ModerationAPIRequest();
request.setInput("your input text");
request.setModel("text-moderation-latest"); // model name
```

2. Initialize the `EasyopenaiService` object with an instance of `DAOImpl` and Make the API call::

```java
EasyopenaiService obj = new EasyopenaiService(new DAOImpl());
ModerationAPIResponse res = obj.getmoderation(OPENAI_KEY, request);
```

3. Print the response:

```java
System.out.println(res);
```

Click [here](#moderation-api) to jump to the code example.

## Vision API

Vision API 
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
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setRole("user");
    chatMessage.setContent("what is the capital of Cambodia?");
    
    List<ChatMessage> messages = new ArrayList<>();
    messages.add(chatMessage);
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
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setRole("user");
    chatMessage.setContent("what is the capital of India?");
    List<ChatMessage> messages = new ArrayList<>();
    messages.add(chatMessage);
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
    <version>1.0.0</version>
</dependency>
```

## Groovy - Gradle
```
implementation group: 'io.github.namankhurpia', name: 'easyopenai', version: '1.0.0'
```

## Gradle Java -
```
implementation 'io.github.namankhurpia:easyopenai:1.0.0'
```
## Gradle Kotlin-
```
implementation("io.github.namankhurpia:easyopenai:1.0.0")
```
## SBT -
```
libraryDependencies += "io.github.namankhurpia" % "easyopenai" % "1.0.0"
```
## Ivy-
```
<dependency org="io.github.namankhurpia" name="easyopenai" rev="1.0.0"/>
```
## Grape-
```
@Grapes(
@Grab(group='io.github.namankhurpia', module='easyopenai', version='1.0.0')
)
```
## Leiningen
```
[io.github.namankhurpia/easyopenai "1.0.0"]
```
## Buildr
```
'io.github.namankhurpia:easyopenai:jar:1.0.0'
```