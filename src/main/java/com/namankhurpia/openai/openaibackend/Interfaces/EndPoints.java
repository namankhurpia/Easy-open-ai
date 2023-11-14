package com.namankhurpia.openai.openaibackend.Interfaces;

public interface EndPoints {

    static final String BASE_URL = "https://api.openai.com/";

    //Newer models (2023–) gpt-4 (and gpt-4 turbo), gpt-3.5-turbo
    static final String completion_gpt4_gpt3_newmodel = "https://api.openai.com/v1/chat/completions";

    //Updated base models (2023) babbage-002, davinci-002
    static final String completion_babbage02_davinci_02 = "https://api.openai.com/v1/completions";

    //Legacy models (2020–2022) text-davinci-003, text-davinci-002, davinci, curie, babbage, ada
    static final String legacy_models = "https://api.openai.com/v1/completions";
    static final String openai_key = "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";
}
