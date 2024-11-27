package com.techhuntstudio.matrix

import com.techhuntstudio.matrix.themes.JtematrixGenerated
import gg.jte.TemplateOutput
import gg.jte.html.HtmlInterceptor
import gg.jte.output.FileOutput
import kotlin.io.path.Path

fun main() {
    val templateOutput = FileOutput(Path("src/main/resources/matrix.theme.json"))
    JtematrixGenerated.render(templateOutput, null)
    templateOutput.close()
}