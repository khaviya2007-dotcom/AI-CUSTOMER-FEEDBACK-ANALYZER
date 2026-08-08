# Workspace AI Agent Instructions

## Overview
- This workspace currently contains only design artifacts and diagrams:
  - `ABSTRACT (5).docx`
  - `Algorithm.docx`
  - `ER DIAGRAM.png`
  - `Flow Chart.png`
- No source code, build scripts, or project configuration files were detected in the repository root.

## Guidance for AI agents
- Do not assume a programming language, framework, or build system unless the user explicitly provides one.
- Before writing code, ask the user for the intended project type, target language, and where source files should be placed.
- If the user is starting a new project, recommend an appropriate project scaffold only after confirming requirements.
- If the user wants help with documentation or design artifacts, focus on clarifying requirements and improving conceptual structure.
- When asked to run shell commands, use the terminal and prefer an editor-integrated execution path such as `code-runner.runInTerminal` if available.

## Useful behavior
- Prefer questions over guesswork when the workspace lacks code.
- When asked to generate project structure, keep it minimal and aligned with the user’s confirmed stack.
- If the user references one of the existing documents, use it as the primary source of requirements.

## Notes
- This file is meant to help AI agents be immediately productive in an otherwise empty or design-only workspace.
