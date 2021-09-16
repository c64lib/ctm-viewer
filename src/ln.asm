#import "common/lib/mem.asm"
#import "common/lib/invoke.asm"
#import "chipset/lib/mos6510.asm"
#import "chipset/lib/cia.asm"
#import "chipset/lib/vic2.asm"
#import "ln-meta.asm"

.filenamespace c64lib

.segmentdef Code [start=$0810]
.file [name="./ln.prg", segments="Code", modify="BasicUpstart", _start=$0810]

.segment Code

#import "_common.asm"

charset:
    .import binary "ln-charset.bin"
endCharset:
charsetColours:
    .import binary "ln-colours.bin"
endCharsetColours:
charsetScreenColours:
    .import binary "ln-screen-colours.bin"
endCharsetScreenColours:

.print "Charset size        = " + (endCharset - charset)
.print "Colour RAM size     = " + (endCharsetColours - charsetColours)
.print "Screen colours size = " + (endCharsetScreenColours - charsetScreenColours)