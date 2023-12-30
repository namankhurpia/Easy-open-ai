# How to Contribute

## How to Add a New API

### Add POJOs to API library
I have manually read all documentation given by OpenAI and then decided to make the models. 

- Make all java variables camel case, and use `@JsonProperty` for fields that OpenAI returns as snake case
- Include comments for each variable, I take these directly from the OpenAI website
- Include `@Builder @NoArgsConstructor @AllArgsConstructor @Data` on every request/response/model class.
- The flow of the Application goes like - Documentation/RunnerForSingleInstance.java -> Service/EasyopenaiService.java -> DAO/DAOImpl.java -> OPENAI's server
- Add as many checks as you can to validate all mandatory parameters, saving all network requests.

### Add an Integration Test
Since 99% of the work of this library is done on OpenAI's servers, the objective of these tests is to call each endpoint at least once.  
Specify every available parameter to make sure that OpenAI accepts everything, but don't create extra test cases unless a parameter drastically affects the results.  

I request you to please check the file [RunnerForSingleInstance](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForSingleInstance.java) for single threaded response. Please test the function you added/changed, Make a proper call using real key.

Similarly for Concurrent - [RunnerForConcurrent](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForConcurrent.java)  and [RunnerForAsync](https://github.com/namankhurpia/Easy-open-ai/blob/main/src/main/java/io/github/namankhurpia/Documentation/RunnerForAsync.java) for Asynchronous Multithreaded Tasks.