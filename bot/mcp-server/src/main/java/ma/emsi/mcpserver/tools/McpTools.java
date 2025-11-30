package ma.emsi.mcpserver.tools;

import org.springaicommunity.mcp.annotation.McpArg;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class McpTools {
    @McpTool(name = "getEmployee",
         description = "Get information about a given employee")
    public Employee getEmployee(@McpArg(description = "The employee name") String name) {
        return new Employee(name, 12300, 4);
    }

    @McpTool(description = "Get All Employees")
    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee("Hajar", 40000, 4),
                new Employee("Hind", 30000, 1),
                new Employee("Mehdi", 50000, 5)
        );
    }
}

record Employee(String nom, double salary, int seniority) {
}
