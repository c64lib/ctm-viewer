import com.github.c64lib.retroassembler.domain.AssemblerType

plugins {
    id("com.github.c64lib.retro-assembler") version "1.4.3"
}

repositories {
     mavenCentral()
}

retroProject {
    dialect = AssemblerType.KickAssembler
    dialectVersion = "5.20"
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
}