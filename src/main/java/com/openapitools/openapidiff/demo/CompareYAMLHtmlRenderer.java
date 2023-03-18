package com.openapitools.openapidiff.demo;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;

import java.io.FileWriter;

public class CompareYAMLHtmlRenderer {
  public static void main(String[] args) throws Exception {
    if (args.length!=2) System.out.println("Insufficient arguments, expecting 2 file name in argument");
    final String oldFileName = args[0];
    final String newFileName = args[1];
    HtmlRender render = new HtmlRender();
    ChangedOpenApi diff = OpenApiCompare.fromLocations(oldFileName, newFileName);
    System.out.println(render.render(diff));
    final String outputFileName = oldFileName.substring(0, oldFileName.indexOf('.')) + "_"
            + newFileName.substring(0, newFileName.indexOf('.'))+"_"+System.currentTimeMillis()+".html";
    FileWriter fw = new FileWriter(outputFileName);
    fw.write(render.render(diff));
    fw.close();
  }
}
