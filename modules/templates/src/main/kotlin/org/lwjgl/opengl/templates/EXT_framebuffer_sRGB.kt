/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
package org.lwjgl.opengl.templates

import org.lwjgl.generator.*
import org.lwjgl.opengl.*

val EXT_framebuffer_sRGB = "EXTFramebufferSRGB".nativeClassGL("EXT_framebuffer_sRGB", postfix = EXT) {
	documentation =
		"""
		Native bindings to the $registryLink extension.

		Conventionally, OpenGL assumes framebuffer color components are stored in a linear color space. In particular, framebuffer blending is a linear
		operation.

		The sRGB color space is based on typical (non-linear) monitor characteristics expected in a dimly lit office. It has been standardized by the
		International Electrotechnical Commission (IEC) as IEC 61966-2-1. The sRGB color space roughly corresponds to 2.2 gamma correction.

		This extension adds a framebuffer capability for sRGB framebuffer update and blending. When blending is disabled but the new sRGB updated mode is
		enabled (assume the framebuffer supports the capability), high-precision linear color component values for red, green, and blue generated by fragment
		coloring are encoded for sRGB prior to being written into the framebuffer. When blending is enabled along with the new sRGB update mode, red, green, and
		blue framebuffer color components are treated as sRGB values that are converted to linear color values, blended with the high-precision color values
		generated by fragment coloring, and then the blend result is encoded for sRGB just prior to being written into the framebuffer.

		The primary motivation for this extension is that it allows OpenGL applications to render into a framebuffer that is scanned to a monitor configured to
		assume framebuffer color values are sRGB encoded. This assumption is roughly true of most PC monitors with default gamma correction. This allows
		applications to achieve faithful color reproduction for OpenGL rendering without adjusting the monitor's gamma correction.

		${GL30.promoted}
		"""

	IntConstant(
		"""
		Accepted by the {@code cap} parameter of Enable, Disable, and IsEnabled, and by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and
		GetDoublev.
		""",

		"FRAMEBUFFER_SRGB_EXT" _ 0x8DB9
	)

	IntConstant(
		"Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev.",

		"FRAMEBUFFER_SRGB_CAPABLE_EXT" _ 0x8DBA
	)
}

val GLX_EXT_framebuffer_sRGB = "GLXEXTFramebufferSRGB".nativeClassWGL("GLX_EXT_framebuffer_sRGB", EXT) {
	documentation =
		"""
		Native bindings to the ${registryLink("EXT", "framebuffer_sRGB")} extension.

		GLX functionality for ${EXT_framebuffer_sRGB.link}.
		"""

	IntConstant(
		"Accepted by the {@code attribList} parameter of glXChooseVisual, and by the {@code attrib} parameter of glXGetConfig.",

		"FRAMEBUFFER_SRGB_CAPABLE_EXT" _ 0x20B2
	)
}

val WGL_EXT_framebuffer_sRGB = "WGLEXTFramebufferSRGB".nativeClassWGL("WGL_EXT_framebuffer_sRGB", EXT) {
	documentation =
		"""
		Native bindings to the ${registryLink("EXT", "framebuffer_sRGB")} extension.

		WGL functionality for ${EXT_framebuffer_sRGB.link}.

		Requires ${WGL_EXT_extensions_string.link} and ${WGL_ARB_pixel_format.link}.
		"""

	IntConstant(
		"""
		Accepted by the {@code piAttributes} parameter of wglGetPixelFormatAttribivEXT, wglGetPixelFormatAttribfvEXT, and the {@code piAttribIList} and
		{@code pfAttribIList} of wglChoosePixelFormatEXT.
		""",

		"FRAMEBUFFER_SRGB_CAPABLE_EXT" _ 0x20A9
	)
}