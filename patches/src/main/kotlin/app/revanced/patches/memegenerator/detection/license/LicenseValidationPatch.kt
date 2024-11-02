package app.revanced.patches.memegenerator.detection.license

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.util.matchOrThrow

val licenseValidationPatch = bytecodePatch(
    description = "Disables Firebase license validation.",
) {

    execute {
        licenseValidationFingerprint.matchOrThrow.method.replaceInstructions(
            0,
            """
                const/4 p0, 0x1
                return  p0
            """,
        )
    }
}
