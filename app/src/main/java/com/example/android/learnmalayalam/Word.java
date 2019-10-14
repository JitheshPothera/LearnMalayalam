package com.example.android.learnmalayalam;



public class Word {

    private String mMalayalamTranslation;
    private String mDefaultTranslation;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private int mSoundResourceID = NO_SOUND_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Constant value that represents no sound was provided for this word */
    private static final int NO_SOUND_PROVIDED = -1;


    public Word(String malayalamTranslation, String defaultTranslation, int soundResourceID) {
        mMalayalamTranslation = malayalamTranslation;
        mDefaultTranslation = defaultTranslation;
        mSoundResourceID = soundResourceID;
    }

    public Word(String malayalamTranslation, String defaultTranslation, int imageResourceID, int soundResourceID) {
        mMalayalamTranslation = malayalamTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceID = imageResourceID;
        mSoundResourceID = soundResourceID;
    }

    public String getMalayalamTraslation() {
        return mMalayalamTranslation;
    }

    public String getDefaultTraslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceID() {return mImageResourceID;}
    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    public int getSoundResourceID() { return mSoundResourceID;}


}

