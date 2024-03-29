package io.github.namankhurpia.Pojo.ChatCompletion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


/**
 * This class encapsulates - System Message, User Message, Assistant Message, Tool Message, Function Message
 * Refer - https://platform.openai.com/docs/api-reference/chat/create
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    @NonNull
    String role;

    @NonNull
    @JsonInclude() // content should always exist in the call, even if it is null
    String content;
    //name is optional, The name of the author of this message. May contain a-z, A-Z, 0-9, and underscores, with a maximum length of 64 characters.
    String name;

    @JsonProperty("tool_calls")
    List<ToolCalls> tool_calls;

    @JsonProperty("function_call")
    ChatFunctionCall function_call;

    @JsonProperty("tool_call_id")
    String tool_call_id;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public Message(String role, String content, String name) {
        this.role = role;
        this.content = content;
        this.name = name;
    }

}
