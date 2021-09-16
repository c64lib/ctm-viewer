import com.github.c64lib.retroassembler.domain.AssemblerType

plugins {
    id("com.github.c64lib.retro-assembler") version "1.4.4"
}

repositories {
     mavenCentral()
}

retroProject {
    dialect = AssemblerType.KickAssembler
    dialectVersion = "5.21"
    libDirs = arrayOf(".ra/deps/c64lib", "build/charpad")
    srcDirs = arrayOf("src")
    excludes = arrayOf("**/_*.asm")

    libFromGitHub("c64lib/common", "develop")
    libFromGitHub("c64lib/chipset", "develop")
    libFromGitHub("c64lib/text", "develop")
    libFromGitHub("c64lib/copper64", "develop")
}

preprocess {
    charpad {
      getInput().set(file("src/ctm/Draconus (1x1).ctm"))
      getUseBuildDir().set(true)
      outputs {
        meta {
          dialect = AssemblerType.KickAssembler
          namespace = "c64lib"
          output = file("draconus-meta.asm")
          includeVersion = true
          includeMode = true
        }
        charset {
          output = file("draconus-charset.bin")
        }
        charsetColours {
          output = file("draconus-colours.bin")
        }
        charsetScreenColours {
          output = file("draconus-screen-colours.bin")
        }
      }
    }
    charpad {
      getInput().set(file("src/ctm/Rambo (1x1).ctm"))
      getUseBuildDir().set(true)
      outputs {
        meta {
          dialect = AssemblerType.KickAssembler
          namespace = "c64lib"
          output = file("rambo-meta.asm")
          includeVersion = true
          includeMode = true
        }
        charset {
          output = file("rambo-charset.bin")
        }
        charsetColours {
          output = file("rambo-colours.bin")
        }
        charsetScreenColours {
          output = file("rambo-screen-colours.bin")
        }
      }
    }
    charpad {
      getInput().set(file("src/ctm/Arkanoid.ctm"))
      getUseBuildDir().set(true)
      outputs {
        meta {
          dialect = AssemblerType.KickAssembler
          namespace = "c64lib"
          output = file("arkanoid-meta.asm")
          includeVersion = true
          includeMode = true
        }
        charset {
          output = file("arkanoid-charset.bin")
        }
        charsetColours {
          output = file("arkanoid-colours.bin")
        }
        charsetScreenColours {
          output = file("arkanoid-screen-colours.bin")
        }
      }
    }
    charpad {
      getInput().set(file("src/ctm/Last Ninja, The.ctm"))
      getUseBuildDir().set(true)
      outputs {
        meta {
          dialect = AssemblerType.KickAssembler
          namespace = "c64lib"
          output = file("ln-meta.asm")
          includeVersion = true
          includeMode = true
        }
        charset {
          output = file("ln-charset.bin")
        }
        charsetColours {
          output = file("ln-colours.bin")
        }
        charsetScreenColours {
          output = file("ln-screen-colours.bin")
        }
      }
    }
    charpad {
      getInput().set(file("src/ctm/Ghosts n Goblins.ctm"))
      getUseBuildDir().set(true)
      outputs {
        meta {
          dialect = AssemblerType.KickAssembler
          namespace = "c64lib"
          output = file("gng-meta.asm")
          includeVersion = true
          includeMode = true
        }
        charset {
          output = file("gng-charset.bin")
        }
        charsetColours {
          output = file("gng-colours.bin")
        }
        charsetScreenColours {
          output = file("gng-screen-colours.bin")
        }
      }
    }

}