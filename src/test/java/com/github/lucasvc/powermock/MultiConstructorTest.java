/*
 * Copyright (c) 1999-2017 Safelayer Secure Communications, S.A.
 *
 * All rights reserved. No part of this source code may be reproduced,
 * stored in a retrieval system, or transmitted, in any form or by any
 * means, electronic, mechanical, photocopying, recording or otherwise,
 * except as in the end-user license agreement, without the prior
 * permission of the copyright owner.
 */

package com.github.lucasvc.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MultiConstructor.class })
public class MultiConstructorTest {

	private @Captor ArgumentCaptor<String> firstCaptor;

	private @Captor ArgumentCaptor<String> secondCaptor;

	private @Mock MultiConstructor mock;

	@Test
	public void whenNewCapturing() throws Exception {
		PowerMockito.whenNew(MultiConstructor.class).withParameterTypes(String.class, String.class)
				.withArguments(firstCaptor.capture(), secondCaptor.capture()).thenReturn(mock);

		Assert.assertSame(mock, MultiConstructor.factory());
		Assert.assertEquals(16, firstCaptor.getValue().length());
		Assert.assertEquals(32, secondCaptor.getValue().length());
	}

}
