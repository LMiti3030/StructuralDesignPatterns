package mititelu.laura.another.ex;

import java.util.List;
import java.util.stream.Collectors;

public class PrintFormatter implements Formatter{
    @Override
    public String format(String header, List<Detail> details) {
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        builder.append("\n");
//        for(Detail detail : details){
//            builder.append(detail.getLabel());
//            builder.append(" : ");
//            builder.append(detail.getValue());
//            builder.append("\n");
//        }

        builder.append(details
                .stream()
                .map( d -> d.getLabel() + " : " + d.getValue() )
                .collect(Collectors.joining("\n")));

        return builder.toString();
    }
}
