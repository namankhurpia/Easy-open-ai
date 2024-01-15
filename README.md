# Easy-open-ai
This repository contains the community-maintained library for OpenAI's API in java, the easiest way to use GPT 3/4 in your applications.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.namankhurpia/easyopenai/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.namankhurpia/easyopenai)

[![Your Custom Badge](https://img.shields.io/badge/Easyopenai-1.0.7-brightgreen)](https://central.sonatype.com/artifact/io.github.namankhurpia/easyopenai)

## Overview

This Java library (community-maintained Library) provides a convenient way to interact with OpenAI's API for both Moderation and Chat Completion. The library encapsulates the necessary details, making it easy to integrate OpenAI's powerful models into your Java applications. This project is not maintained by OPENAI, this is an unofficial library.

## Table of Contents

- [Dependencies](#Dependencies) 

### Single Instance

- [Chat Completion API](#chat-completion-api)
- [Moderation API](#moderation-api)
- [Easy Vision API](#easy-vision-api)  or  [Vision API](#vision-api) (original provided by OpenAI)
- [Speech API](#speech-api)
- [Easy Transcription API](#easy-transcription-api) or [Transcription API](#transcription-api) (original provided by OpenAI)
- [Image generation API](#image-generation-api)  also called as DALL-E API

### Asynchronous

- [Async Chat Completion API](#async-chat-completion-api)
- [Async Moderation API](#async-moderation-api)

### Multi-Asynchronous

- [Multithreaded Async Chat Completion API](#multithreaded-async-chat-completion-api)
- [Multithreaded Async Moderation API](#multithreaded-async-moderation-api)

### Multi-Asynchronous-MultiKey 

- [EMMC EasyOpenAI Multithreaded MultiKey ChatCompletionAPI](#EMMC EasyOpenAI Multithreaded MultiKey ChatCompletionAPI)


# Contributing Guidelines
Please refer [CONTRIBUTING.md](https://github.com/namankhurpia/Easy-open-ai/blob/main/CONTRIBUTING.md)


# Running guidelines
All "OPENAI_KEYS" must be read through the readKeys() function defined [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java), this function allows you to read multiple keys at the same time, and for multithreaded task it is adviced to use multiple keys to avoid rate limiting. To run this function you need to have keys.txt in your project root folder (feel free to edit).


# Usage - syntax 

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

ChatCompletionResponse response = new EasyopenaiService(new DAOImpl()).chatCompletion("OPENAI_KEY",request);

```

Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.

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

Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.

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

## Speech API
Speech API can be used like this, feel free to tweak-

```java
SpeechRequest request = SpeechRequest.builder()
       .model("tts-1")
       .input("Easy OpenAI is best solution.")
       .voice("alloy")
       .build();

ResponseBody response = new EasyopenaiService(new DAOImpl()).createSpeech("OPENAI_KEY",request);

```
Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.


## Easy Transcription API

Transcription API can be used like this, feel free to tweak-

```java
EasyTranscriptionRequest request  =  EasyTranscriptionRequest.builder()
      .filepath("/Users/namankhurpia/Desktop/audio.mp3")
      .model("whisper-1")
      .build();

ResponseBody response = new EasyTranscriptionService().EasyTranscription("OPENAI_KEY", request);
```

Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.


## Transcription API

### Original Transcription API by OpenAI
Transcription API can be used like this, feel free to tweak-


```java
File audioFile = new File("/Users/namankhurpia/Desktop/audio.mp3");
MultipartBody.Part filePart = MultipartBody.Part.createFormData(
       "file",
       audioFile.getName(),
       RequestBody.create(MediaType.parse("audio/*"), audioFile)
);

RequestBody model = RequestBody.create(MediaType.parse("text/plain"), "whisper-1");
RequestBody language = RequestBody.create(MediaType.parse("text/plain"), "");
RequestBody prompt = RequestBody.create(MediaType.parse("text/plain"), "");
RequestBody response_format = RequestBody.create(MediaType.parse("text/plain"), "");
RequestBody temperature = RequestBody.create(MediaType.parse("text/plain"), "");

ResponseBody response = new EasyopenaiService(new DAOImpl()).createTranscriptions("OPENAI_KEY", filePart,model, language,prompt,response_format,temperature);
```

Click [here](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) to jump to the code example.


## Image Generation API

Image Generation API can be used like this, feel free to tweak-

```java
ImageRequest imageRequest  = ImageRequest.builder()
       .prompt("Generate a cute dog playing with frizbee")
       .model("dall-e-2")
       .build();

ImageResponse response = new EasyopenaiService(new DAOImpl()).createImage("OPENAI_KEY",imageRequest);
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

## EMMC EasyOpenAI Multithreaded MultiKey ChatCompletionAPI

This allows you to make multiple Chat completion calls with multiple keys. All API calls are executed parallely but the response is actively collected and sent back when all the threads are finished.

CompletableFuture class has been used for implementation. Kindly refer EasyopenaiConcurrentService.java file to see the source. 

Example Usgage-

```java
public static void CallMultipleChatCompletionAPI_multikey_Test()
{
     //this function read multiple keys from keys.txt file 
     ArrayList<String> keyList = readKeys();
     
     EasyopenaiConcurrentService concurrentCalls = new EasyopenaiConcurrentService();
   
     ChatCompletionRequestList list = new ChatCompletionRequestList(new ArrayList<ChatCompletionRequest>());
   
     //First thread for 
     ChatCompletionRequest requestchat = new ChatCompletionRequest();
     requestchat.setModel("gpt-3.5-turbo");
     Message message = new Message();
     message.setRole("user");
     message.setContent("what is the capital of India?");
     List<Message> messages = new ArrayList<>();
     messages.add(message);
     requestchat.setMessages(messages);
     list.add(requestchat);
   
   
     ChatCompletionRequest requestchat2 = new ChatCompletionRequest();
     requestchat2.setModel("gpt-3.5-turbo");
     Message message2 = new Message();
     message2.setRole("user");
     message2.setContent("what is the capital of combodia?");
     List<Message> messages2 = new ArrayList<>();
     messages2.add(message2);
     requestchat2.setMessages(messages2);
     list.add(requestchat2);
   
   
     ChatCompletionRequest requestchat3 = new ChatCompletionRequest();
     requestchat3.setModel("gpt-3.5-turbo");
     Message message3 = new Message();
     message3.setRole("user");
     message3.setContent("what is the capital of new zealand?");
     List<Message> messages3 = new ArrayList<>();
     messages3.add(message3);
     requestchat3.setMessages(messages3);
     list.add(requestchat3);
   
   
     ChatCompletionRequest requestchat4 = new ChatCompletionRequest();
     requestchat4.setModel("gpt-3.5-turbo");
     Message message4 = new Message();
     message4.setRole("user");
     message4.setContent("what is the capital of hawaii? and what is 2+2?");
     List<Message> messages4 = new ArrayList<>();
     messages4.add(message4);
     requestchat4.setMessages(messages4);
     list.add(requestchat4);
   
   
   
     ChatCompletionResponseList responseList = concurrentCalls.CallMultipleChatCompletionAPI(keyList, list);
     System.out.println("response is"+responseList);
}
```

# Dependencies

Ensure you have the required dependencies installed before using the OpenAI API wrapper.


## Maven

```xml
<dependency>
    <groupId>io.github.namankhurpia</groupId>
    <artifactId>easyopenai</artifactId>
    <version>x.x.x</version>
</dependency>
```

## Groovy - Gradle
```
implementation group: 'io.github.namankhurpia', name: 'easyopenai', version: 'x.x.x'
```

## Gradle Java -
```
implementation 'io.github.namankhurpia:easyopenai:x.x.x'
```
## Gradle Kotlin-
```
implementation("io.github.namankhurpia:easyopenai:x.x.x")
```
## SBT -
```
libraryDependencies += "io.github.namankhurpia" % "easyopenai" % "x.x.x"
```
## Ivy-
```
<dependency org="io.github.namankhurpia" name="easyopenai" rev="x.x.x"/>
```
## Grape-
```
@Grapes(
@Grab(group='io.github.namankhurpia', module='easyopenai', version='x.x.x')
)
```
## Leiningen
```
[io.github.namankhurpia/easyopenai "x.x.x"]
```
## Buildr
```
'io.github.namankhurpia:easyopenai:jar:x.x.x'
```