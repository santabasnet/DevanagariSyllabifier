# Unicode Character Tokenizer

### This work syllabifies(a kind of) Devanagari characters from the given word.
### Usage:
-----
```Java
    String testData = "राष्ट्रियताको";
    UnicodeCharacterTokenizer tokenizer;
    String numberTest = "१२३४०";

    tokenizer = new UnicodeCharacterTokenizer(testData);
    String resultOutcome1 = tokenizer.GetGroupedCharacters().toString();
    System.out.println("\nInput: " + testData);
    System.out.println("\t" + resultOutcome1);

    tokenizer = new UnicodeCharacterTokenizer(numberTest);
    String resultOutcome2 = tokenizer.GetGroupedCharacters().toString();
    System.out.println("\nInput: " + numberTest);
    System.out.println("\t" + resultOutcome2);
  
```
