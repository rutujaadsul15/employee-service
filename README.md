Actuator Enpoint Response:
http://localhost:8085/actuator
{
	"_links": {
		"self": {
			"href": "http://localhost:8085/actuator",
			"templated": false
		},
		"beans": {
			"href": "http://localhost:8085/actuator/beans",
			"templated": false
		},
		"health": {
			"href": "http://localhost:8085/actuator/health",
			"templated": false
		},
		"health-path": {
			"href": "http://localhost:8085/actuator/health/{*path}",
			"templated": true
		},
		"info": {
			"href": "http://localhost:8085/actuator/info",
			"templated": false
		},
		"shutdown": {
			"href": "http://localhost:8085/actuator/shutdown",
			"templated": false
		},
		"configprops": {
			"href": "http://localhost:8085/actuator/configprops",
			"templated": false
		},
		"configprops-prefix": {
			"href": "http://localhost:8085/actuator/configprops/{prefix}",
			"templated": true
		},
		"metrics": {
			"href": "http://localhost:8085/actuator/metrics",
			"templated": false
		},
		"metrics-requiredMetricName": {
			"href": "http://localhost:8085/actuator/metrics/{requiredMetricName}",
			"templated": true
		},
		"mappings": {
			"href": "http://localhost:8085/actuator/mappings",
			"templated": false
		}
	}
}
