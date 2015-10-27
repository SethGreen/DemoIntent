package com.algonquincollege.hurdleg.demointent;

// TODO code inspection (read and understand the code).
/**
 * The better way to define constants is to use a Java class.
 *
 * Credit: much thanks to Bo Y. for bringing this issue to my attention!
 *
 * Reference:
 *     http://stackoverflow.com/questions/2659593/what-is-the-use-of-interface-constants
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
public class Constants {

    public static final String  ABOUT_DIALOG_TAG = "About";
    public static final char    DEFAULT_LETTER   = 'A';
    public static final String  LETTERS          = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String  LOG_TAG          = "DEMO-INTENT";
    // TODO replace "mad9132" with your AC username (e.g. bond0007)
    public static final String  THE_MESSAGE      = "com.algonquincollege.mad9132.demointent.message";
    // TODO replace "mad9132" with your AC username (e.g. bond007)
    public static final String  THE_LETTER       = "com.algonquincollege.mad9132.demointent.letter";

    // TODO please read.
    // Pro-tip: prevent instantiation of this class by defining a private no-arg constructor.
    //          Java will not assume the default constructor, because we've defined the no-arg
    //          constructor.
    //          Your project will NOT build if you try this:
    //              Constants constants = new Constants();
    //          Go ahead and try it for your self :)
    private Constants() { }
}
