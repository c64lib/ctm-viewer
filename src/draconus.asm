#import "common/lib/mem.asm"
#import "common/lib/invoke.asm"
#import "chipset/lib/mos6510.asm"
#import "chipset/lib/cia.asm"
#import "chipset/lib/vic2.asm"
#import "draconus-meta.asm"

.filenamespace c64lib

.segmentdef Code [start=$0810]
.file [name="./draconus.prg", segments="Code", modify="BasicUpstart", _start=$0810]

.segment Code

#import "_common.asm"

charset:
    .import binary "draconus-charset.bin"
endCharset:
charsetColours:
    .import binary "draconus-colours.bin"
endCharsetColours:
charsetScreenColours:
    .import binary "draconus-screen-colours.bin"
endCharsetScreenColours:

.print "Charset size        = " + (endCharset - charset)
.print "Colour RAM size     = " + (endCharsetColours - charsetColours)
.print "Screen colours size = " + (endCharsetScreenColours - charsetScreenColours)