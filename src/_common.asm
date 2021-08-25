.filenamespace c64lib

.label CHARSET_ADDR = $E000
.label SCREEN_ADDR = $C000

start:
    jsr configureC64
    jsr unpackData
    jsr configureVic2
    loop:
        jmp loop

configureC64: {
    sei
    configureMemory(RAM_IO_RAM)
    disableNMI()
    disableCIAInterrupts()
    cli
    rts
}

unpackData: {
    // charset
    pushParamW(charset)
    pushParamW(CHARSET_ADDR)
    pushParamW(endCharset - charset)
    jsr copyLargeMemForward
    // color RAM
    pushParamW(charsetColours)
    pushParamW(COLOR_RAM)
    pushParamW(endCharsetColours - charsetColours)
    jsr copyLargeMemForward
    // screen colours
    pushParamW(charsetScreenColours)
    pushParamW(SCREEN_ADDR)
    pushParamW(endCharsetScreenColours - charsetScreenColours)
    jsr copyLargeMemForward
    rts
}

configureVic2: {
    lda #backgroundColour0
    sta BORDER_COL
    sta BG_COL_0
    setVideoMode(MULTICOLOR_BITMAP_MODE)
    setVICBank(0)
    configureBitmapMemory(0, 1)
    rts
}

#import "common/lib/sub/copy-large-mem-forward.asm"
