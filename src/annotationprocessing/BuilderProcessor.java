package annotationprocessing;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Set;

import static java.lang.annotation.ElementType.FIELD;

@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("annotationprocessing.Builder")
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.forEach(annotation -> {
            roundEnv.getElementsAnnotatedWith(annotation)
                    .forEach(this::generateBuilderFile);
        });
        return false;
    }

    private void generateBuilderFile(Element element) {
        String className = element.getSimpleName().toString();
        String packageName = element.getEnclosingElement().toString();
        String builderName = className + "Builder";
        String builderFullName = packageName + "." + builderName;

        List<? extends Element> fields = element.getEnclosedElements()
                .stream().filter(e -> FIELD.equals(e.getKind())).toList();
    }
}
