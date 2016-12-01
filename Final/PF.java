/* Generated By:JavaCC: Do not edit this line. PF.java */
        import java.io.PrintWriter;
        import java.io.FileOutputStream;
        import java.io.File;

public class PF implements PFConstants {
  public static void main(String args[]) throws ParseException
  {
        String fullReturn = "";
    try
    {

      PF parser = new PF(new java.io.FileInputStream(args[0]));
      fullReturn = parser.Input(fullReturn);
    }
    catch(java.io.FileNotFoundException e){     System.out.println("El archivo no esta..."); }
    try {
        PrintWriter writer = new PrintWriter("result.html", "UTF-8");
                writer.println(fullReturn);
        writer.close();
    } catch (Exception e) { System.out.println("Output file cannot be created"); }
  }

  static final public String Input(String x) throws ParseException {
        String node_string;
        Token title_a;
        System.out.println("Todo bien");
    jj_consume_token(CREATE);
    jj_consume_token(PAGE);
    jj_consume_token(WITH);
    jj_consume_token(TITLE);
    title_a = jj_consume_token(ID);
    jj_consume_token(BA);
    node_string = Contenido();
    jj_consume_token(BC);
    jj_consume_token(0);
        x = "<!DOCTYPE html>\u005cn";
        x += "<html>\u005cn";
        x += "<head>\u005cn";
        x += "<meta charset='UTF-8'>\u005cn";
        x += "<title>";
        x += title_a.image;
        x += "</title>\u005cn";
        x += "</head>\u005cn";
        x += "<body>\u005cn";
        x += node_string;
        //System.out.println(node_string);
        x += "</html>\u005cn";
        {if (true) return x;}
    throw new Error("Missing return statement in function");
  }

  static final public String Contenido() throws ParseException {
        String current_string="";
        String temp = "";
        Token times;
    label_1:
    while (true) {
      temp = Content();
                          current_string += temp;
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ENTERO:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_2;
        }
        times = jj_consume_token(ENTERO);
        jj_consume_token(TIMES);
                                                                            current_string += times.image;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TABLE:
      case HEADER:
      case FOOTER:
      case SIDEBAR:
      case NAV:
      case DIV:
      case AUDIO:
      case VIDEO:
      case LIST:
      case PARAGRAPH:
      case TITLE:
      case SUBTITLE:
      case SECTION:
      case IMAGE:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
        System.out.println(current_string);
                {if (true) return current_string;}
    throw new Error("Missing return statement in function");
  }

  static final public String Content() throws ParseException {
        String curr;
        String acum;
        Token name;
        Token class_;
        Token text_type;
        Token description;
        String acum_desc = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AUDIO:
    case VIDEO:
    case IMAGE:
      acum = MediaStructures();
      jj_consume_token(WITH);
      jj_consume_token(CLASS);
      jj_consume_token(EQUAL);
      class_ = jj_consume_token(ID);
      jj_consume_token(AND);
      jj_consume_token(IDG);
      jj_consume_token(EQUAL);
      name = jj_consume_token(ID);
      jj_consume_token(PCOMA);
          //This string concat is for Media 
                curr = acum;
                curr += " class = '" + class_.image + "' id = '" + name.image + "'";
                System.out.println(curr);
                {if (true) return curr;}
      break;
    case PARAGRAPH:
    case TITLE:
    case SUBTITLE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PARAGRAPH:
        text_type = jj_consume_token(PARAGRAPH);
        break;
      case TITLE:
        text_type = jj_consume_token(TITLE);
        break;
      case SUBTITLE:
        text_type = jj_consume_token(SUBTITLE);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(DP);
      label_3:
      while (true) {
        description = jj_consume_token(ID);
                                                                                                           acum_desc += " " + description.image;
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_3;
        }
      }
      jj_consume_token(PCOMA);
                if(text_type.image == "paragraph") {

                        curr = "<p>" + acum_desc + "</p>\u005cn";
                }
                else if (text_type.image == "title"){
                        curr = "<h1>" + acum_desc + "</h1>\u005cn";
                }
                else if (text_type.image == "subtitle"){
                        curr = "<h2>" + acum_desc + "</h2>\u005cn";
                }
                else{ curr = "Error!!!!";}
                {if (true) return curr;}
      break;
    case TABLE:
    case SIDEBAR:
    case NAV:
    case LIST:
      StructureElementsWithElements();
      jj_consume_token(PCOMA);
                curr = "St";
                {if (true) return curr;}
      break;
    case DIV:
    case SECTION:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIV:
        text_type = jj_consume_token(DIV);
        break;
      case SECTION:
        text_type = jj_consume_token(SECTION);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(WITH);
      jj_consume_token(CLASS);
      jj_consume_token(EQUAL);
      class_ = jj_consume_token(ID);
      jj_consume_token(AND);
      jj_consume_token(IDG);
      jj_consume_token(EQUAL);
      name = jj_consume_token(ID);
      jj_consume_token(PCOMA);
                if(text_type.image == "div"){
                        curr = "<div id = '"+ name.image +"' class= '" + class_.image + "' >";
                }
                else if (text_type.image == "section")
                {
                        curr = "<section id = '"+ name.image +"' class= '" + class_.image + "' >";
                }
                else{
                        curr = "Error!!!!";
                }

                {if (true) return curr;}
      break;
    case HEADER:
    case FOOTER:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case HEADER:
        text_type = jj_consume_token(HEADER);
        break;
      case FOOTER:
        text_type = jj_consume_token(FOOTER);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(BA);
      StAttributes();
      jj_consume_token(BC);
      jj_consume_token(PCOMA);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                if(text_type.image == "header"){
                        curr = "<header>";
                }
                else if (text_type.image == "footer")
                {
                        curr = "<footer>";
                }
                else{
                        curr = "Error!!!!";
                }
                {if (true) return curr;}
    throw new Error("Missing return statement in function");
  }

  static final public void StAttributes() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AUDIO:
    case VIDEO:
    case IMAGE:
      MediaStructures();
      StAttributes();

      break;
    case TABLE:
    case SIDEBAR:
    case NAV:
    case LIST:
      StructureElementsWithElements();
      StAttributes();

      break;
    default:
      jj_la1[7] = jj_gen;

    }
  }

  static final public void StructureElementsWithElements() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TABLE:
      jj_consume_token(TABLE);
      jj_consume_token(WITH);
      jj_consume_token(BA);
      jj_consume_token(PA);
      jj_consume_token(ENTERO);
      jj_consume_token(COLUMNS);
      jj_consume_token(AND);
      jj_consume_token(ENTERO);
      jj_consume_token(ROWS);
      jj_consume_token(PC);
      jj_consume_token(CA);
      TableContent();
      jj_consume_token(CC);
      jj_consume_token(BC);
      break;
    case LIST:
      jj_consume_token(LIST);
      jj_consume_token(WITH);
      jj_consume_token(ENTERO);
      jj_consume_token(ITEMS);
      break;
    case SIDEBAR:
      jj_consume_token(SIDEBAR);
      jj_consume_token(WITH);
      jj_consume_token(BA);
      AttributesForBar();
      jj_consume_token(CA);
      label_4:
      while (true) {
        jj_consume_token(ID);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
      }
      jj_consume_token(CC);
      jj_consume_token(BC);
      break;
    case NAV:
      jj_consume_token(NAV);
      jj_consume_token(WITH);
      jj_consume_token(BA);
      AttributesForBar();
      jj_consume_token(BC);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TableContent() throws ParseException {
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PA:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_5;
      }
      jj_consume_token(PA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        label_6:
        while (true) {
          jj_consume_token(ID);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case ID:
            ;
            break;
          default:
            jj_la1[11] = jj_gen;
            break label_6;
          }
        }
        break;
      case ENTERO:
        jj_consume_token(ENTERO);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(PC);
    }
  }

  static final public void AttributesForBar() throws ParseException {
    jj_consume_token(ENTERO);
    jj_consume_token(ITEMS);
    jj_consume_token(WITH);
    jj_consume_token(STYLE);
    BarStyle();
  }

  static final public void BarStyle() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SMALLBLOCK:
      jj_consume_token(SMALLBLOCK);
      break;
    case MEDIUMBLOCK:
      jj_consume_token(MEDIUMBLOCK);
      break;
    case LARGEBLOCK:
      jj_consume_token(LARGEBLOCK);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public String MediaStructures() throws ParseException {
        String att_st_audio = "";
        String att_st_img = "";
        String att_st_video = "";
        String media_st = "";
        Token name;
        Token class_;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IMAGE:
      jj_consume_token(IMAGE);
      jj_consume_token(BA);
      att_st_img = ImgAttributes();
      jj_consume_token(BC);
                                                          media_st += "<img src="; media_st += att_st_img+"'>"; {if (true) return media_st;}
      break;
    case AUDIO:
      jj_consume_token(AUDIO);
      jj_consume_token(BA);
      att_st_audio = AudioAttributes();
      jj_consume_token(BC);
                                                              media_st += "\u005cn\u005cn<audio controls>\u005cn"; media_st += att_st_audio; media_st += "Your browser does not support the audio element.</audio>"; {if (true) return media_st;}
      break;
    case VIDEO:
      jj_consume_token(VIDEO);
      jj_consume_token(BA);
      att_st_video = MediaAttributes();
      jj_consume_token(BC);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(WITH);
    jj_consume_token(CLASS);
    jj_consume_token(EQUAL);
    class_ = jj_consume_token(ID);
    jj_consume_token(AND);
    jj_consume_token(IDG);
    jj_consume_token(EQUAL);
    name = jj_consume_token(ID);
    jj_consume_token(PCOMA);
                                                                                                                                              media_st += "\u005cn\u005cn<video"; media_st += att_st_video; media_st += "</video>";
        {if (true) return media_st;}
    throw new Error("Missing return statement in function");
  }

  static final public String MediaAttributes() throws ParseException {
 String source_st = ""; Token file; Token format; Token width_video; Token height_video;
    jj_consume_token(SOURCE);
    file = jj_consume_token(ID);
    jj_consume_token(PUNTO);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOV:
      format = jj_consume_token(MOV);
      break;
    case MP4:
      format = jj_consume_token(MP4);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMA);
    jj_consume_token(WIDTH);
    jj_consume_token(EQUAL);
    width_video = jj_consume_token(ENTERO);
    jj_consume_token(PX);
    jj_consume_token(COMA);
    jj_consume_token(HEIGHT);
    jj_consume_token(EQUAL);
    height_video = jj_consume_token(ENTERO);
    jj_consume_token(PX);
         source_st = " width='" + width_video.image + "'"+" height='" + height_video.image + "' controls>\u005cn \u005ct<source src='" + file.image + "." + format.image + "' type='video/mp4'>\u005cn" ;
        {if (true) return source_st;}
    throw new Error("Missing return statement in function");
  }

  static final public String AudioAttributes() throws ParseException {
 String source_st = ""; Token file; Token format;
    jj_consume_token(SOURCE);
    file = jj_consume_token(ID);
    jj_consume_token(PUNTO);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MP3:
      format = jj_consume_token(MP3);
      break;
    case WAV:
      format = jj_consume_token(WAV);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                                                            source_st = "\u005ct<source src = '" + file.image + "." + format.image + "' type='audio/mpeg'>";
        {if (true) return source_st;}
    throw new Error("Missing return statement in function");
  }

  static final public String ImgAttributes() throws ParseException {
        String source_st = "";
        Token width_img;
        Token height_img;
        Token format;
        Token file;
    jj_consume_token(SOURCE);
    file = jj_consume_token(ID);
    jj_consume_token(PUNTO);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case JPG:
      format = jj_consume_token(JPG);
      break;
    case PNG:
      format = jj_consume_token(PNG);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMA);
    jj_consume_token(WIDTH);
    jj_consume_token(EQUAL);
    width_img = jj_consume_token(ENTERO);
    jj_consume_token(PX);
    jj_consume_token(COMA);
    jj_consume_token(HEIGHT);
    jj_consume_token(EQUAL);
    height_img = jj_consume_token(ENTERO);
    jj_consume_token(PX);
                source_st ="'" +file.image + "." + format.image + "' width = '" + width_img.image + "px' height = " + height_img.image + "px'";
                {if (true) return source_st;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public PFTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[18];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0xef900000,0x0,0x0,0x8000000,0x1800000,0xef900000,0xe6100000,0x0,0x86100000,0x80,0x0,0x0,0x0,0x60000000,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x10000000,0x600e,0xe,0x8000000,0x2000,0x0,0x600e,0x4000,0x8000000,0x0,0x0,0x8000000,0x18000000,0x700,0x4000,0x300000,0xc00000,0x3000000,};
   }

  /** Constructor with InputStream. */
  public PF(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public PF(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new PFTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public PF(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new PFTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public PF(PFTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(PFTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[62];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 18; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 62; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
