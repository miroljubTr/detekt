package io.gitlab.arturbosch.detekt.formatting

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

/**
 * @author Artur Bosch
 */
class FormattingProvider : RuleSetProvider {

	override val ruleSetId: String = "formatting"

	override fun instance(config: Config): RuleSet {
		return RuleSet(ruleSetId, mutableListOf(
				ConsecutiveBlankLines(config),
				MultipleSpaces(config),
				SpacingAfterComma(config),
				SpacingAfterKeyword(config),
				SpacingAroundColon(config),
				SpacingAroundBraces(config),
				SpacingAroundOperator(config),
				TrailingSpaces(config),
				UnusedImports(config),
				OptionalSemicolon(config),
				OptionalUnit(config),
				ExpressionBodySyntaxLineBreaks(config),
				ExpressionBodySyntax(config),
				OptionalReturnKeyword(config)
		).apply {
			if (!config.valueOrDefault("useTabs", false)) {
				add(Indentation(config))
			}
		})
	}
}
