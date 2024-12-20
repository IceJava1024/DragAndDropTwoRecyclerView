package com.espresso.draganddrop.model

import com.espresso.draganddrop.R

enum class FormatModel(
    val titleId: Int,
    val imageId: Int,
    val formatType: TypeModel = TypeModel.OTHER
) {
    ACC(
        R.string.aac_format,
        R.mipmap.aac
    ),
    CSV(
        R.string.csv_format,
        R.mipmap.csv
    ),
    DOCX(
        R.string.docx_format,
        R.mipmap.docx
    ),
    FLAC(
        R.string.flac_format,
        R.mipmap.flac
    ),
    GIF(
        R.string.gif_format,
        R.mipmap.gif
    ),
    HTML(
        R.string.html_format,
        R.mipmap.html
    ),
    JPG(
        R.string.jpg_format,
        R.mipmap.jpg
    ),
    JS(
        R.string.js_format,
        R.mipmap.js
    ),
    M4A(
        R.string.m4a_format,
        R.mipmap.m4a
    ),
    MIDI(
        R.string.midi_format,
        R.mipmap.midi
    ),
    MKV(
        R.string.mkv_format,
        R.mipmap.mkv
    ),
    MP3(
        R.string.mp3_format,
        R.mipmap.mp3
    ),
    MP4(
        R.string.mp4_format,
        R.mipmap.mp4
    ),
    OGG(
        R.string.ogg_format,
        R.mipmap.ogg
    ),
    OGV(
        R.string.ogv_format,
        R.mipmap.ogv
    ),
    PDF(
        R.string.pdf_format,
        R.mipmap.pdf
    ),
    PNG(
        R.string.png_format,
        R.mipmap.png
    ),
    PPT(
        R.string.ppt_format,
        R.mipmap.ppt
    ),
    RAR(
        R.string.rar_format,
        R.mipmap.rar
    ),
    SVG(
        R.string.svg_format,
        R.mipmap.svg,
        TypeModel.COMMON
    ),
    TXT(
        R.string.txt_format,
        R.mipmap.txt,
        TypeModel.COMMON
    ),
    WAV(
        R.string.wav_format,
        R.mipmap.wav,
        TypeModel.COMMON
    ),
    WEBM(
        R.string.webm_format,
        R.mipmap.webm,
        TypeModel.COMMON
    ),
    WEBP(
        R.string.webp_format,
        R.mipmap.webp,
        TypeModel.COMMON
    ),
    XLSX(
        R.string.xlsx_format,
        R.mipmap.xlsx,
        TypeModel.COMMON
    ),
    ZIP(
        R.string.zip_format,
        R.mipmap.zip,
        TypeModel.COMMON
    )
}