package io.github.sbliquibase.domain.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "EXAMPLE")
class ExampleModel : Serializable {
    /**
     * ID cannot be a lateinit field!
     */
    @Id
    @Column(name = "ID", nullable = false)
    var id: Long? = null

    /**
     * Mandatory field without initialization
     */
    @Column(name = "MANDATORY_FIELD", nullable = false)
    lateinit var mandatoryField: String

    /**
     * Nullable field
     */
    @Column(name = "NULLABLE_FIELD", nullable = true)
    var nullableField: String? = null

    companion object {
        private const val serialVersionUID: Long = 6099236490907509445L
    }
}
